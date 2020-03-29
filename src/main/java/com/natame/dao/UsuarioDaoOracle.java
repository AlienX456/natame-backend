package com.natame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.natame.auth.Usuario;
import com.natame.model.UsuarioPagos;
import com.natame.util.RHException;
import com.natame.util.ServiceLocator2;

public class UsuarioDaoOracle implements IUsuarioDao{

	@Override
	public void registrarUsuario(Usuario user, UsuarioPagos userp) throws RHException {
		try {
			
			String strSQL = "INSERT INTO USUARIO VALUES(?,?,?,?)";
			
			Connection conexion = ServiceLocator2.getInstance().tomarConexion(user);
			
			System.out.println("nombre "+userp.getNUMIDENTIFICACION());
			
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			prepStmt.setInt(1, userp.getNUMIDENTIFICACION());
			prepStmt.setString(2, userp.getNOMBRE());
			prepStmt.setString(3, userp.getCLAVE());
			prepStmt.setString(4, userp.getTIPOIDENTIFICACION());
			prepStmt.executeUpdate();
			prepStmt.close();
			
	          String strSQL2 = "CREATE USER "+userp.getNOMBRE()+" "
  					+ "IDENTIFIED BY "+userp.getCLAVE()+" "
  					+ "DEFAULT TABLESPACE USER_NATAME "
  					+ "TEMPORARY TABLESPACE USRTEMP_NATAME "
  					+ "QUOTA 2M ON USER_NATAME";
			prepStmt = conexion.prepareStatement(strSQL2);
			prepStmt.executeUpdate();
			prepStmt.close();
			
	      /*String strSQL3 = "GRANT CONNECT TO "+userp.getNOMBRE();
	      prepStmt = conexion.prepareStatement(strSQL3);
	      prepStmt.executeUpdate();
	      prepStmt.close();*/

			
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
	        	throw new RHException( this.getClass().getName(), " Error en registrarUsuario() ROLLBACK "+ excep.getMessage());
	       }
        	throw new RHException( this.getClass().getName(), " Error en registrarUsuario() "+ e.getMessage());
		}
		finally {
			ServiceLocator2.getInstance().liberarConexion();
	    }
		
	}

	@Override
	public UsuarioPagos obtenerUsuario(Usuario user, int id) throws RHException {
		// TODO Auto-generated method stub
		return null;
	}

}
