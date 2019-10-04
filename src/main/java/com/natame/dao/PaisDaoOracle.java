package com.natame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.natame.auth.Usuario;
import com.natame.model.Pais;
import com.natame.util.RHException;
import com.natame.util.ServiceLocator;

import java.util.ArrayList;

public class PaisDaoOracle implements IPaisDao{

	@Override
	public void incluirPais(Pais pais, Usuario user) throws RHException {
      try {
          String strSQL = "INSERT INTO PAIS(PK_N_IDPAIS,V_NOMBREPAIS) VALUES(Seq_Pais.nextval,?)";
          Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
          prepStmt.setString(1, pais.getNOMBREPAIS());  
          prepStmt.executeUpdate();
          prepStmt.close();
          ServiceLocator.getInstance().commit();
        } catch (Exception e) {
            try {
            	if (ServiceLocator.getInstance().getConexion()!=null) {
                    System.err.print("se enviara petición de Rollback");
                    ServiceLocator.getInstance().rollback();
            	}
            } catch(Exception excep) {
            	throw new RHException( this.getClass().getName(), " Error en incluirPais() ROLLBACK "+ excep.getMessage());
            }
            throw new RHException( this.getClass().getName(), " Error en incluirPais() "+ e.getMessage());
		}  finally {
           ServiceLocator.getInstance().liberarConexion();
        }
	}

	@Override
	public void modificarPais(Pais pais, Usuario user) throws RHException {
	try {
        String strSQL = "UPDATE PAIS set V_NOMBREPAIS WHERE PK_N_IDPAIS=?";
        Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        prepStmt.setString(1, pais.getNOMBREPAIS()); 
        prepStmt.setInt(2,pais.getIDPAIS());  
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
      }catch (Exception e) {
    	  try {
          	if (ServiceLocator.getInstance().getConexion()!=null) {
                  System.err.print("se enviara petición de Rollback");
                  ServiceLocator.getInstance().rollback();
          	}
          } catch(Exception excep) {
          	throw new RHException( this.getClass().getName(), " Error en modificarPais() ROLLBACK "+ excep.getMessage());
          }
    	  throw new RHException( this.getClass().getName(), " Error en  modificarPais() "+ e.getMessage());
	} finally {
         ServiceLocator.getInstance().liberarConexion();
      }
	}

	@Override
	public Pais buscarPais(Integer pais_id, Usuario user) throws RHException {
		Pais resultado = new Pais();
		try {
			String strSQL = "SELECT * FROM PAIS WHERE PK_N_IDPAIS=?";
			Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
	        prepStmt.setInt(1, pais_id); 
	        ResultSet rs = prepStmt.executeQuery();
	        rs.next();
	        resultado.setIDPAIS(rs.getInt("PK_N_IDPAIS"));
	        resultado.setNOMBREPAIS(rs.getString("V_NOMBREPAIS"));
	        prepStmt.close();
	        return resultado;
			}catch (Exception e) {
	    	   throw new RHException( this.getClass().getName(), "Error en buscarPais() "+ e.getMessage());
			}  finally {
	          ServiceLocator.getInstance().liberarConexion();
	       }
		
	}

	@Override
	public void borrarPais(Integer pais_id, Usuario user) throws RHException {
	try {
        String strSQL = "DELETE FROM PAIS WHERE PK_N_IDPAIS=?";
        Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        prepStmt.setInt(1,pais_id);  
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
      }catch (Exception e) {
    	  try {
	        	if (ServiceLocator.getInstance().getConexion()!=null) {
	                System.err.print("se enviara petición de Rollback");
	                ServiceLocator.getInstance().rollback();
	        	}
	        } catch(Exception excep) {
	        	throw new RHException( this.getClass().getName(), " Error en borrarPais() ROLLBACK "+ excep.getMessage());
	        }
		  	throw new RHException( this.getClass().getName(), " Error en borrarPais() "+ e.getMessage());
	}  finally {
         ServiceLocator.getInstance().liberarConexion();
      }
		
	}

	@Override
	public Pais[] verPaises(Usuario user) throws RHException {
	ArrayList<Pais> lista = new ArrayList<Pais>();
	try {
		String strSQL = "SELECT * FROM PAIS";
		Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
		PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        ResultSet rs = prepStmt.executeQuery();
        while(rs.next()) {
        	lista.add(new Pais(rs.getInt("PK_N_IDPAIS"),rs.getString("V_NOMBREPAIS")));
        }
        prepStmt.close();
		}catch (Exception e) {
    	   throw new RHException( this.getClass().getName(), "Error en verPaises() "+ e.getMessage());
		}finally {
		  ServiceLocator.getInstance().liberarConexion(); 
       }
		return lista.toArray(new Pais[lista.size()]);
	}

}
