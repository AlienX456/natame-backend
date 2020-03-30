package com.natame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.natame.auth.Usuario;
import com.natame.model.RepresentanteVentas;
import com.natame.util.RHException;
import com.natame.util.ServiceLocator;

public class RepresentanteVentasDaoOracle implements IRepresentanteVentasDao{

	@Override
	public void registrarRepresentanteVentas(RepresentanteVentas rp, Usuario user) throws RHException {
	      try {
	    	  
	          String strSQL = "INSERT INTO REPRESENTANTEVENTAS "
	          		+ "VALUES(?,?,?,?,?,TO_DATE(?, 'DD-MM-YYYY'),TO_DATE(?, 'DD-MM-YYYY'),?,?,?,?,?,"
	          		+ "(SELECT K_TIPOID FROM REPRESENTANTEVENTAS WHERE C_USUARIO=?),"
	          		+ "(SELECT K_IDENTIFICACION FROM REPRESENTANTEVENTAS WHERE C_USUARIO=?),"
	          		+ "?,NULL)";
	          Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
	          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
	          prepStmt.setInt(1, rp.getIDENTIFICACION()); 
	          prepStmt.setString(2, rp.getTIPOID());
	          prepStmt.setString(3, rp.getNOMBRE());
	          prepStmt.setString(4, rp.getCORREOELECTRONICO()); 
	          prepStmt.setString(5, rp.getGENERO()); 
	          prepStmt.setString(6, rp.getFECHANACIMIENTO()); 
	          prepStmt.setString(7, rp.getFECHACONTRATO()); 
	          prepStmt.setString(8, rp.getTELEFONOCONTACTO()); 
	          prepStmt.setString(9, rp.getDIRECCION());
	          prepStmt.setString(10, rp.getESDIRECTOR());
	          prepStmt.setString(11, rp.getGRADO());
	          prepStmt.setInt(12, rp.getREGION());
	          prepStmt.setString(13, user.getNombre());
	          prepStmt.setString(14, user.getNombre());
	          prepStmt.setString(15, rp.getUSUARIO());
	          prepStmt.executeUpdate();
	          prepStmt.close();
	          
	          System.out.println("-");
	          
	          //USUARIO
	          String strSQL2 = "CREATE USER "+rp.getUSUARIO()+" "
	          					+ "IDENTIFIED BY "+rp.getIDENTIFICACION()+" "
	          					+ "DEFAULT TABLESPACE USER_NATAME "
	          					+ "TEMPORARY TABLESPACE USRTEMP_NATAME "
	          					+ "QUOTA 2M ON USER_NATAME";
	          prepStmt = conexion.prepareStatement(strSQL2);
	          prepStmt.executeUpdate();
	          prepStmt.close();
	          
	          System.out.println("--");
	          
	          //PERMISOS
	          String strSQL3 = "";
	          
	          if(rp.getGRADO().equals("MASTER")) {
		          strSQL3 = "GRANT R_RV TO "+rp.getUSUARIO()+" WITH ADMIN OPTION";
	          }else {
		          strSQL3 = "GRANT R_RV TO "+rp.getUSUARIO();
	          }
	          
	          prepStmt = conexion.prepareStatement(strSQL3);
	          prepStmt.executeUpdate();
	          prepStmt.close();
	          
		      String strSQL4 = "GRANT R_CLIENTE,CONNECT TO "+rp.getUSUARIO()+" WITH ADMIN OPTION";
		      prepStmt = conexion.prepareStatement(strSQL4);
		      prepStmt.executeUpdate();
		      prepStmt.close();
	          
	          if(rp.getGRADO().equals("MASTER")) {
			      String strSQL5 = "GRANT R_RVM TO "+rp.getUSUARIO();
			      prepStmt = conexion.prepareStatement(strSQL5);
			      prepStmt.executeUpdate();
			      prepStmt.close();
	          }

			
				System.out.println("---");
				
	          ServiceLocator.getInstance().commit();
	          
	          
	        } catch (Exception e) {
	      	  try {
		        	if (ServiceLocator.getInstance().getConexion()!=null) {
		                System.err.print("se enviara petición de Rollback");
		                ServiceLocator.getInstance().rollback();
		        	}
		        } catch(Exception excep) {
		        	throw new RHException( this.getClass().getName(), " Error en registrarRepresentanteVentas() ROLLBACK "+ excep.getMessage());
		        }
	        	throw new RHException( this.getClass().getName(), " Error en registrarRepresentanteVentas() "+ e.getMessage());
			}  finally {
	           ServiceLocator.getInstance().liberarConexion();
	        }
	}
	
	@Override
	public RepresentanteVentas buscarRepresentanteVentas(Usuario user) throws RHException {
		RepresentanteVentas resultado = new RepresentanteVentas();
		try {
			String strSQL = "SELECT * FROM REPRESENTANTEVENTAS WHERE C_USUARIO=?";
			Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
	        prepStmt.setString(1, user.getNombre());
	        ResultSet rs = prepStmt.executeQuery();
	        rs.next();
	        resultado.setIDENTIFICACION(rs.getInt("K_IDENTIFICACION"));
	        resultado.setNOMBRE(rs.getString("C_NOMBRE"));
	        resultado.setCORREOELECTRONICO(rs.getString("C_CORREOELECTRONICO"));
	        resultado.setGENERO(rs.getString("I_GENERO"));
	        resultado.setFECHANACIMIENTO(rs.getString("F_NACIMIENTO"));
	        resultado.setFECHACONTRATO(rs.getString("F_CONTRATO"));
	        resultado.setTELEFONOCONTACTO(rs.getString("N_TELEFONO"));
	        resultado.setDIRECCION(rs.getString("C_DIRECCION"));
	        resultado.setESDIRECTOR(rs.getString("I_ESDIRECTOR"));
	        resultado.setGRADO(rs.getString("K_GRADORV"));
	        resultado.setREGION(rs.getInt("K_REGION"));
	        resultado.setRVMTIPOID(rs.getString("K_RVMTIPOID"));
	        resultado.setRVMID(rs.getInt("K_RVMID"));
	        resultado.setUSUARIO(rs.getString("C_USUARIO"));
	        prepStmt.close();
	        return resultado;
			}catch (Exception e) {
	    	   throw new RHException( this.getClass().getName(), "Error en buscarRepresentanteVentas "+ e.getMessage());
			}  finally {
	          ServiceLocator.getInstance().liberarConexion();
	       }
		
	}

}
