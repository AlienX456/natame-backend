package com.natame.dao;

import java.sql.Connection;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Types;

import com.natame.auth.Usuario;
import com.natame.model.Factura;
import com.natame.util.RHException;
import com.natame.util.ServiceLocator;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.OracleCallableStatement;
import oracle.sql.BFILE;

public class FuncionesNatameOracle implements IFuncionesNatame{

	@Override
	public Float calcularIVAProductoFU(String nombre, Usuario user) throws RHException {
		try {
			String llamado = "{ ? = call PK_INVENTARIO.FU_CALCULAR_IVA( ?, ?, ?) }";
			Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
			CallableStatement callStmt = conexion.prepareCall(llamado);
			callStmt.registerOutParameter(1, Types.NUMERIC);
			callStmt.setString(2,nombre);
			callStmt.registerOutParameter(3,Types.NUMERIC);
			callStmt.registerOutParameter(4,Types.VARCHAR);
	        callStmt.executeUpdate();
	        float result = callStmt.getFloat(1);
	        callStmt.close();
	        return result;
			}catch (Exception e) {
	    	   throw new RHException( this.getClass().getName(), "Error en calcularIVAProductoFU() "+ e.getMessage());
			}finally {
			  ServiceLocator.getInstance().liberarConexion();
	       }
			
	}

	@Override
	public String generarFacturaFU(int id_pedido, Usuario user) throws RHException {
		try {
			//OBTENE IDENTIFICACION USUARIO

			Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
		    
			String llamado = "{ ? = call PK_FACTURA.FU_GENERAR_FACTURA( ?, ?, ?) }";
			OracleCallableStatement callStmt = (OracleCallableStatement)conexion.prepareCall(llamado);
			callStmt.registerOutParameter(1, OracleTypes.BFILE);
			callStmt.setInt(2,id_pedido);
			callStmt.registerOutParameter(3,Types.NUMERIC);
			callStmt.registerOutParameter(4,Types.VARCHAR);
	        callStmt.execute();

	        BFILE bfile = callStmt.getBFILE(1);
	        
	        bfile.openFile();
	        
	        InputStream in = bfile.getBinaryStream();
	        
	        int length ;
	        
	        byte[] buf = new byte[500];
	        
	        String datos_bfile  = "";
	        
	        while ((length = in.read(buf)) != -1)
	        {
	            // append and display the bfile data in 6-byte chunks 
	           StringBuffer sb = new StringBuffer(length);
	           for (int i=0; i<length; i++)
	              sb.append( (char)buf[i] );
	           datos_bfile += sb.toString();
	        }

	        // we are done working with the input stream. Close it. 
	        
	        in.close();

	        // we are done working with the BFILE. Close it.  
	        bfile.closeFile();
	        
	        callStmt.close();
	        
	        return datos_bfile;
	        
			}catch (Exception e) {
	    	   throw new RHException( this.getClass().getName(), "Error en generarFacturaFU() "+ e.getMessage());
			}finally {
			  ServiceLocator.getInstance().liberarConexion();
	       }
	}
	
	/*
	   n_cantidad         detallepedido.n_cantidad%TYPE,
       c_nombre           producto.c_nombre%TYPE,
       t_precio           inventario.t_precio%TYPE

	*/

	@Override
	public void calificarRVFU(int pedido, int calificacion, Usuario user) throws RHException {
		// TODO Auto-generated method stub
		
	}


}
