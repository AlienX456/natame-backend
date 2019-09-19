package com.natame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.natame.model.Pais;
import com.natame.util.RHException;
import com.natame.util.ServiceLocator;

import java.util.ArrayList;

public class PaisDaoOracle implements IPaisDao{

	@Override
	public void incluirPais(Pais pais) throws RHException {
      try {
          String strSQL = "INSERT INTO PAIS(PK_N_IDPAIS,V_NOMBREPAIS) VALUES(?,?)";
          Connection conexion = ServiceLocator.getInstance().tomarConexion();
          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
          prepStmt.setInt(1,pais.getIDPAIS()); 
          prepStmt.setString(2, pais.getNOMBREPAIS());  
          prepStmt.executeUpdate();
          prepStmt.close();
          ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
             throw new RHException( this.getClass().getName(), " No pudo crear el pais"+ e.getMessage());
        }  finally {
           ServiceLocator.getInstance().liberarConexion();
        }
	}

	@Override
	public void modificarPais(Pais pais) throws RHException {
	try {
        String strSQL = "UPDATE PAIS set V_NOMBREPAIS WHERE PK_N_IDPAIS=?";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        prepStmt.setString(1, pais.getNOMBREPAIS()); 
        prepStmt.setInt(2,pais.getIDPAIS());  
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
      } catch (SQLException e) {
           throw new RHException( this.getClass().getName(), " Error "+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }
	}

	@Override
	public Pais buscarPais(Integer pais_id) throws RHException {
		Pais resultado = new Pais();
		try {
			String strSQL = "SELECT * FROM PAIS WHERE PK_N_IDPAIS=?";
			Connection conexion = ServiceLocator.getInstance().tomarConexion();
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
	        prepStmt.setInt(1, pais_id); 
	        ResultSet rs = prepStmt.executeQuery();
	        rs.next();
	        resultado.setIDPAIS(rs.getInt("PK_N_IDPAIS"));
	        resultado.setNOMBREPAIS(rs.getString("V_NOMBREPAIS"));
	        prepStmt.close();
			}
	        catch (SQLException e) {
	            throw new RHException( this.getClass().getName(), "Error "+ e.getMessage());
	       }  finally {
	          ServiceLocator.getInstance().liberarConexion();
	          
	       }
		return resultado;
		
	}

	@Override
	public void borrarPais(Integer pais_id) throws RHException {
	try {
        String strSQL = "DELETE FROM PAIS WHERE PK_N_IDPAIS=?";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        prepStmt.setInt(1,pais_id);  
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
      } catch (SQLException e) {
           throw new RHException( this.getClass().getName(), " Error "+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }
		
	}

	@Override
	public Pais[] verPaises() throws RHException {
		ArrayList<Pais> lista = new ArrayList<Pais>();
		try {
			String strSQL = "SELECT * FROM PAIS";
			Connection conexion = ServiceLocator.getInstance().tomarConexion();
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
	        ResultSet rs = prepStmt.executeQuery();
	        while(rs.next()) {
	        	lista.add(new Pais(rs.getInt("PK_N_IDPAIS"),rs.getString("V_NOMBREPAIS")));
	        }
	        prepStmt.close();
			}
	        catch (SQLException e) {
	            throw new RHException( this.getClass().getName(), " No pudo recolectar la lista "+ e.getMessage());
	       }  finally {
	          ServiceLocator.getInstance().liberarConexion();
	          
	       }
		return lista.toArray(new Pais[lista.size()]);
	}

}
