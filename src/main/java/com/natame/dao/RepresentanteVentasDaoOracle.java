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
	    	  
	    	  //TABLA
	          String strSQL = "INSERT INTO REPRESENTANTEVENTAS VALUES(?,?,?,?,TO_DATE(?, 'DD-MM-YYYY'),TO_DATE(?, 'DD-MM-YYYY'),?,?,?,?,?,?)";
	          Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
	          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
	          prepStmt.setInt(1, rp.getIDENTIFICACION()); 
	          prepStmt.setString(2, rp.getNOMBRE());
	          prepStmt.setString(3, rp.getCORREOELECTRONICO()); 
	          prepStmt.setString(4, rp.getGENERO()); 
	          prepStmt.setString(5, rp.getFECHANACIMIENTO()); 
	          prepStmt.setString(6, rp.getFECHACONTRATO()); 
	          prepStmt.setString(7, rp.getTELEFONOCONTACTO()); 
	          prepStmt.setString(8, rp.getDIRECCION());
	          prepStmt.setString(9, rp.getESDIRECTOR());
	          prepStmt.setInt(10, rp.getREGION());
	          prepStmt.setString(11, rp.getGRADO());
	          prepStmt.setInt(12, rp.getRPM());
	          prepStmt.executeUpdate();
	          prepStmt.close();
	          
	          System.out.println("-");
	          
	          //USUARIO
	          String strSQL2 = "CREATE USER U"+rp.getIDENTIFICACION()+" "
	          					+ "IDENTIFIED BY "+rp.getIDENTIFICACION()+" "
	          					+ "DEFAULT TABLESPACE USER_TABLE "
	          					+ "TEMPORARY TABLESPACE USER_TABLE_TEMP "
	          					+ "QUOTA 2M ON USER_TABLE";
	          prepStmt = conexion.prepareStatement(strSQL2);
	          prepStmt.executeUpdate();
	          prepStmt.close();
	          
	          System.out.println("--");
	          
	          //PERMISOS
	          String strSQL3 = "GRANT R_RV TO U"+rp.getIDENTIFICACION();
	          prepStmt = conexion.prepareStatement(strSQL3);
	          prepStmt.executeUpdate();
	          prepStmt.close();
		      String strSQL4 = "GRANT R_CLIENTE,CONNECT TO U"+rp.getIDENTIFICACION()+" WITH ADMIN OPTION";
		      prepStmt = conexion.prepareStatement(strSQL4);
		      prepStmt.executeUpdate();
		      prepStmt.close();
			
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
	public RepresentanteVentas buscarRepresentanteVentas(int identificacion, Usuario user) throws RHException {
		RepresentanteVentas resultado = new RepresentanteVentas();
		try {
			String strSQL = "SELECT * FROM REPRESENTANTEVENTAS WHERE PK_N_IDENTIFICACION=?";
			Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
	        prepStmt.setInt(1, identificacion); 
	        ResultSet rs = prepStmt.executeQuery();
	        rs.next();
	        resultado.setIDENTIFICACION(rs.getInt("PK_N_IDENTIFICACION"));
	        resultado.setNOMBRE(rs.getString("V_NOMBRE"));
	        resultado.setCORREOELECTRONICO(rs.getString("V_CORREOELECTRONICO"));
	        resultado.setGENERO(rs.getString("V_GENERO"));
	        resultado.setFECHANACIMIENTO(rs.getString("D_FECHANACIMIENTO"));
	        resultado.setFECHACONTRATO(rs.getString("D_FECHACONTRATO"));
	        resultado.setTELEFONOCONTACTO(rs.getString("V_TELEFONOCONTACTO"));
	        resultado.setDIRECCION(rs.getString("V_DIRECCION"));
	        resultado.setESDIRECTOR(rs.getString("V_ESDIRECTOR"));
	        resultado.setGRADO(rs.getString("FK_V_NOMBREGRADO"));
	        resultado.setREGION(rs.getInt("FK_N_IDREGION"));
	        prepStmt.close();
	        return resultado;
			}catch (Exception e) {
	    	   throw new RHException( this.getClass().getName(), "Error en buscarRepresentanteVentas "+ e.getMessage());
			}  finally {
	          ServiceLocator.getInstance().liberarConexion();
	       }
		
	}

}
