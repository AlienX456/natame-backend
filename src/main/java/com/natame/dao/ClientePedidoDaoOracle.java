package com.natame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.natame.auth.Usuario;
import com.natame.model.ClientePedido;
import com.natame.util.RHException;
import com.natame.util.ServiceLocator;

public class ClientePedidoDaoOracle implements IClientePedidoDao{

	@Override
	public void realizarPedido(ClientePedido cp, Usuario user) throws RHException {
	      try {
	    	  Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
	    	  String strSQL1 = "SELECT K_SECUENCIA FROM ASOCIACION WHERE K_IDCLIENTE=? AND K_TIPOIDCLIENTE=? AND F_FIN IS NULL";
	    	  PreparedStatement prepStmt = conexion.prepareStatement(strSQL1);
	          prepStmt.setInt(1, cp.getIdentificacion());
	          prepStmt.setString(2, cp.getTipoid());
	          ResultSet rs = prepStmt.executeQuery();
	          rs.next();
	          int secuencia = rs.getInt("K_SECUENCIA");
	          prepStmt.close();
	          
	          System.out.println("-");
	    	  
	          String strSQL2 = "INSERT INTO PEDIDO VALUES("
	          		+ "ADMINNATAME.SEQ_PEDIDO.NEXTVAL,"
	          		+ "?,"
	          		+ "NULL,"
	          		+ "TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS'),"
	          		+ "?,"
	          		+ "NULL,"
	          		+ "?)";
	          
	          prepStmt = conexion.prepareStatement(strSQL2);
	          prepStmt.setString(1, cp.getESTADO()); 
	          prepStmt.setString(2, cp.getFECHAPEDIDO());
	          prepStmt.setString(3, cp.getMODODEPAGO());
	          prepStmt.setInt(4, secuencia);
	          prepStmt.executeUpdate();
	          prepStmt.close();
	          
	          System.out.println("--");
	          
	          
	          String strSQL3 = "INSERT INTO DETALLEPEDIDO "
	          		+ "VALUES(?,"
	          		+ "(SELECT K_PEDIDO FROM PEDIDO WHERE K_ASOCIACION = ? AND F_PEDIDO = TO_DATE(?,'YYYY-MM-DD HH24:MI:SS')),"
	          		+ "?)";
	          prepStmt = conexion.prepareStatement(strSQL3);
	          prepStmt.setInt(2, secuencia);
	          prepStmt.setString(3, cp.getFECHAPEDIDO());
	          for (int i = 0; i < cp.getPD().length; i++) {
	        	  prepStmt.setInt(1, cp.getPD()[i].getCANTIDAD());
	        	  prepStmt.setInt(4, cp.getPD()[i].getINVENTARIO());
	        	  prepStmt.executeUpdate();
	          }
	          prepStmt.close();
	          
	          System.out.println("---");
	          
	          //ACTUALIZAR INVENTARIO
	          String strSQL4 = "UPDATE INVENTARIO "
	          		+ "SET N_CANTIDAD=(SELECT N_CANTIDAD FROM INVENTARIO WHERE K_INVENTARIO=?)-? WHERE K_INVENTARIO=?";
	          prepStmt = conexion.prepareStatement(strSQL4);
	          for (int i = 0; i < cp.getPD().length; i++) {
	        	  prepStmt.setInt(1, cp.getPD()[i].getINVENTARIO());
	        	  prepStmt.setInt(2, cp.getPD()[i].getCANTIDAD());
	        	  prepStmt.setInt(3, cp.getPD()[i].getINVENTARIO());
	        	  prepStmt.executeUpdate();
	          }
	          prepStmt.close();
	          
	          System.out.println("----");
	          
	          //ACTUALIZAR VALOR
	          String strSQL5 = "UPDATE PEDIDO "
	          		+ "SET T_VALOR=(SELECT SUM(A.N_CANTIDAD*T_PRECIO*(1+T_IMPUESTO)) FROM DETALLEPEDIDO A, INVENTARIO B "
	          		+ "WHERE K_PEDIDO=(SELECT K_PEDIDO FROM PEDIDO WHERE K_ASOCIACION = ? AND F_PEDIDO = TO_DATE(?,'YYYY-MM-DD HH24:MI:SS')) AND B.K_INVENTARIO=A.K_INVENTARIO) "
	          		+ "WHERE K_PEDIDO=(SELECT K_PEDIDO FROM PEDIDO WHERE K_ASOCIACION = ? AND F_PEDIDO = TO_DATE(?,'YYYY-MM-DD HH24:MI:SS'))";
	          prepStmt = conexion.prepareStatement(strSQL5);
	          prepStmt.setInt(1, secuencia);
	          prepStmt.setString(2, cp.getFECHAPEDIDO());
	          prepStmt.setInt(3, secuencia);
	          prepStmt.setString(4, cp.getFECHAPEDIDO());
	          prepStmt.executeUpdate();
	          prepStmt.close();
	          
	          System.out.println("-----");
	          
	          ServiceLocator.getInstance().commit();
	        } catch (Exception e) {
	      	  try {
		        	if (ServiceLocator.getInstance().getConexion()!=null) {
		                System.err.print("se enviara petición de Rollback");
		                ServiceLocator.getInstance().rollback();
		        	}
		        } catch(Exception excep) {
		        	throw new RHException( this.getClass().getName(), " Error en realizarPedido() ROLLBACK "+ excep.getMessage());
		        }
	        	throw new RHException( this.getClass().getName(), " Error en realizarPedido() "+ e.getMessage());
			}  finally {
	           ServiceLocator.getInstance().liberarConexion();
	        }
		
	}

}
