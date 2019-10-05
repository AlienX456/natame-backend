package com.natame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.natame.auth.Usuario;
import com.natame.model.Cliente;
import com.natame.util.RHException;
import com.natame.util.ServiceLocator;

public class ClienteDaoOracle implements IClienteDao{

	@Override
	public Cliente buscarCliente(int cedula, Usuario user) throws RHException {
		Cliente resultado = new Cliente();
		try {
			String strSQL = "SELECT * FROM CLIENTE WHERE PK_N_CEDULA=?";
			Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
	        prepStmt.setInt(1, cedula); 
	        ResultSet rs = prepStmt.executeQuery();
	        rs.next();/*
	        resultado.setCEDULA(rs.getInt("PK_N_CEDULA"));
	        resultado.setNOMBRECLIENTE(rs.getString("V_NOMBRECLIENTE"));
	        resultado.setAPELLIDOCLIENTE(rs.getString("V_APELLIDOCLIENTE"));
	        resultado.setTELEFONO(rs.getString("V_TELEFONO"));
	        resultado.setDIRECCION(rs.getString("V_DIRECCION"));
	        resultado.setCIUDAD(rs.getString("V_CIUDAD"));
	        resultado.setCORREOELECTRONICO(rs.getString("V_CORREOELECTRONICO"));
	        prepStmt.close();*/
	        return resultado;
			}catch (Exception e) {
	    	   throw new RHException( this.getClass().getName(), "Error en buscarCliente() "+ e.getMessage());
			}  finally {
	          ServiceLocator.getInstance().liberarConexion();
	       }
	}

	@Override
	public void registrarCliente(Cliente cliente,Usuario user) throws RHException {
	      try {
	          String strSQL = "INSERT INTO CLIENTE VALUES(?,?,?,?,?,?,?,?,?)";
	          Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
	          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
	          prepStmt.setInt(1, cliente.getIDENTIFICACION()); 
	          prepStmt.setString(2, cliente.getNOMBRE());
	          prepStmt.setString(3, cliente.getAPELLIDO()); 
	          prepStmt.setString(4, cliente.getTELEFONO()); 
	          prepStmt.setString(5, cliente.getDIRECCION()); 
	          prepStmt.setString(6, cliente.getCIUDAD()); 
	          prepStmt.setString(7, cliente.getCORREOELECTRONICO()); 
	          prepStmt.setString(8, cliente.getTIPOID());
	          prepStmt.setString(9, cliente.getUSERNAME()); 
	          prepStmt.executeUpdate();
	          prepStmt.close();
	          System.out.println("-");
	          
	          
	          //ASOCIACION CON RP
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
			
	          String strSQL2 = "INSERT INTO ASOCIACION VALUES"
	          		+ "(TO_DATE(?,'YYYY-MM-DD HH:MI:SS'),"
	          		+ "?,"
	          		+ "adminnatame.SEQ_Asociacion.NEXTVAL,"
	          		+ "?,"
	          		+ "(SELECT K_IDENTIFICACION FROM REPRESENTANTEVENTAS WHERE C_USUARIO=?),"
	          		+ "?,"
	          		+ "(SELECT K_TIPOID FROM REPRESENTANTEVENTAS WHERE C_USUARIO=?))";

	          prepStmt = conexion.prepareStatement(strSQL2);
	          prepStmt.setString(1, dtf.format(LocalDateTime.now()));
	          prepStmt.setNull(2,java.sql.Types.DATE);
	          prepStmt.setInt(3,cliente.getIDENTIFICACION());
	          prepStmt.setString(4,user.getNombre());
	          prepStmt.setString(5,cliente.getTIPOID());
	          prepStmt.setString(6,user.getNombre());
	          prepStmt.executeUpdate();
	          prepStmt.close();
	          
	          System.out.println("--");
	          
	          
	          //USUARIO
	          String strSQL3 = "CREATE USER "+cliente.getUSERNAME()+" "
	          					+ "IDENTIFIED BY "+cliente.getIDENTIFICACION()+" "
	          					+ "DEFAULT TABLESPACE USER_NATAME "
	          					+ "TEMPORARY TABLESPACE USRTEMP_NATAME "
	          					+ "QUOTA 2M ON USER_NATAME";
	          prepStmt = conexion.prepareStatement(strSQL3);
	          prepStmt.executeUpdate();
	          prepStmt.close();
	          
	          System.out.println("---");
	          
	          //PERMISOS
	          String strSQL4 = "GRANT R_CLIENTE,CONNECT TO "+cliente.getUSERNAME();
				prepStmt = conexion.prepareStatement(strSQL4);
				prepStmt.executeUpdate();
				prepStmt.close();
				
				System.out.println("----");
				
				
		    
	          ServiceLocator.getInstance().commit();
	        } catch (Exception e) {
	      	  try {
		        	if (ServiceLocator.getInstance().getConexion()!=null) {
		                System.err.println("se enviara petición de Rollback");
		                ServiceLocator.getInstance().rollback();
		        	}
		        } catch(Exception excep) {
		        	throw new RHException( this.getClass().getName(), " Error en  registrarCliente() ROLLBACK "+ excep.getMessage());
		        }
	        	throw new RHException( this.getClass().getName(), " Error en  registrarCliente() "+ e.getMessage());
			}  finally {
	           ServiceLocator.getInstance().liberarConexion();
	        }
	}
	

	

}
