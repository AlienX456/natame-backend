package com.natame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.natame.auth.Usuario;
import com.natame.model.Cliente;
import com.natame.util.RHException;
import com.natame.util.ServiceLocator;

public class ClienteDaoOracle implements IClienteDao{

	@Override
	public Cliente buscarCliente(int cedula, Usuario user) throws RHException {
		Cliente resultado = new Cliente();
		try {
			String strSQL = "SELECT * FROM NATAME.CLIENTE WHERE PK_N_CEDULA=?";
			Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
	        prepStmt.setInt(1, cedula); 
	        ResultSet rs = prepStmt.executeQuery();
	        rs.next();
	        resultado.setCEDULA(rs.getInt("PK_N_CEDULA"));
	        resultado.setNOMBRECLIENTE(rs.getString("V_NOMBRECLIENTE"));
	        resultado.setAPELLIDOCLIENTE(rs.getString("V_APELLIDOCLIENTE"));
	        resultado.setTELEFONO(rs.getString("V_TELEFONO"));
	        resultado.setDIRECCION(rs.getString("V_DIRECCION"));
	        resultado.setCIUDAD(rs.getString("V_CIUDAD"));
	        resultado.setCORREOELECTRONICO(rs.getString("V_CORREOELECTRONICO"));
	        prepStmt.close();
	        return resultado;
			}catch (Exception e) {
	    	   throw new RHException( this.getClass().getName(), "Error en buscarCliente() "+ e.getMessage());
			}  finally {
	          ServiceLocator.getInstance().liberarConexion();
	       }
	}

}
