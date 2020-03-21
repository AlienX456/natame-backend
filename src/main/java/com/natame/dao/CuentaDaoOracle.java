package com.natame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.natame.auth.Usuario;
import com.natame.model.Cuenta;
import com.natame.util.RHException;
import com.natame.util.ServiceLocator2;

public class CuentaDaoOracle implements ICuentaDao{

	@Override
	public void registrarCuenta(Usuario user, Cuenta cuenta) throws RHException {
		try {
			String strSQL = "INSERT INTO CUENTA VALUES(?,?,?,?)";
			
			Connection conexion = ServiceLocator2.getInstance().tomarConexion(user);
			
			//System.out.println("nombre "+userp.getNUMIDENTIFICACION());
			
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			prepStmt.setInt(1, cuenta.getNUMERO());
			prepStmt.setString(2, cuenta.getSALDO());
			prepStmt.setInt(3, cuenta.getUSUARIO());
			prepStmt.executeUpdate();
			prepStmt.close();
			
			ServiceLocator2.getInstance().commit();
			
		}
		catch (Exception e) {
	  	  try {
	        	if (ServiceLocator2.getInstance().getConexion()!=null) {
	                System.err.print("se enviara petición de Rollback");
	                ServiceLocator2.getInstance().rollback();
	        	}
	        }
	  	  catch(Exception excep) {
	        	throw new RHException( this.getClass().getName(), " Error en registrarCuenta() ROLLBACK "+ excep.getMessage());
	       }
	    	throw new RHException( this.getClass().getName(), " Error en registrarCuenta() "+ e.getMessage());
		}
		finally {
			ServiceLocator2.getInstance().liberarConexion();
	    }
		
	}

	@Override
	public Cuenta obtenerCuenta(Usuario user, int id) throws RHException {
		// TODO Auto-generated method stub
		return null;
	}

}
