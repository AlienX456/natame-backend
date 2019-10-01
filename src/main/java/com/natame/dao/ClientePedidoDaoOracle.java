package com.natame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.natame.auth.Usuario;
import com.natame.model.ClientePedido;
import com.natame.util.RHException;
import com.natame.util.ServiceLocator;

public class ClientePedidoDaoOracle implements IClientePedidoDao{

	@Override
	public void realizarPedido(ClientePedido cp, Usuario user) throws RHException {
	      try {
	          String strSQL = "INSERT INTO PEDIDO VALUES(SEQ_PEDIDO.NEXTVAL,?,?,TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS'),?,?,NULL)";
	          Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
	          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
	          prepStmt.setString(1, cp.getESTADO()); 
	          prepStmt.setString(2, cp.getCALIFICACION());
	          prepStmt.setString(3, cp.getFECHAPEDIDO());
	          prepStmt.setInt(4, cp.getCEDULA());
	          prepStmt.setString(5, cp.getMODODEPAGO());
	          prepStmt.executeUpdate();
	          prepStmt.close();
	          System.out.println("-");
	          
	          
	          String strSQL2 = "INSERT INTO PRODUCTOREGION_PEDIDO "
	          		+ "VALUES(SEQ_PRODUCTOREGIONPEDIDO.NEXTVAL,?,"
	          		+ "(SELECT PK_N_IDPEDIDO FROM PEDIDO WHERE FK_N_CEDULA = ? AND D_FECHAPEDIDO = TO_DATE(?,'YYYY-MM-DD HH24:MI:SS')),"
	          		+ "?)";
	          prepStmt = conexion.prepareStatement(strSQL2);
	          prepStmt.setInt(2, cp.getCEDULA());
	          prepStmt.setString(3, cp.getFECHAPEDIDO());
	          for (int i = 0; i < cp.getPD().length; i++) {
	        	  prepStmt.setInt(1, cp.getPD()[i].getCANTIDAD());
	        	  prepStmt.setInt(4, cp.getPD()[i].getIDPRODUCTOREGION());
	        	  prepStmt.executeUpdate();
	          }
	          prepStmt.close();
	          
	          System.out.println("--");
	          
	          //ACTUALIZAR INVENTARIO
	          String strSQL3 = "UPDATE PRODUCTO_REGION "
	          		+ "SET N_CANTIDAD=(SELECT N_CANTIDAD FROM PRODUCTO_REGION WHERE PK_N_IDPRODUCTOREGION=?)-? WHERE PK_N_IDPRODUCTOREGION=?";
	          prepStmt = conexion.prepareStatement(strSQL3);
	          for (int i = 0; i < cp.getPD().length; i++) {
	        	  prepStmt.setInt(1, cp.getPD()[i].getIDPRODUCTOREGION());
	        	  prepStmt.setInt(2, cp.getPD()[i].getCANTIDAD());
	        	  prepStmt.setInt(3, cp.getPD()[i].getIDPRODUCTOREGION());
	        	  prepStmt.executeUpdate();
	          }
	          prepStmt.close();
	          
	          System.out.println("---");
	          
	          //ACTUALIZAR VALOR
	          String strSQL4 = "UPDATE PEDIDO "
	          		+ "SET V_VALOR=(SELECT SUM(A.N_CANTIDAD*N_PRECIO) FROM PRODUCTOREGION_PEDIDO A, PRODUCTO_REGION B "
	          		+ "WHERE FK_N_IDPEDIDO=(SELECT PK_N_IDPEDIDO FROM PEDIDO WHERE FK_N_CEDULA = ? AND D_FECHAPEDIDO = TO_DATE(?,'YYYY-MM-DD HH24:MI:SS')) AND B.PK_N_IDPRODUCTOREGION=A.FK_N_IDPRODUCTOREGION) "
	          		+ "WHERE PK_N_IDPEDIDO=(SELECT PK_N_IDPEDIDO FROM PEDIDO WHERE FK_N_CEDULA = ? AND D_FECHAPEDIDO = TO_DATE(?,'YYYY-MM-DD HH24:MI:SS'))";
	          prepStmt = conexion.prepareStatement(strSQL4);
	          prepStmt.setInt(1, cp.getCEDULA());
	          prepStmt.setString(2, cp.getFECHAPEDIDO());
	          prepStmt.setInt(3, cp.getCEDULA());
	          prepStmt.setString(4, cp.getFECHAPEDIDO());
	          prepStmt.executeUpdate();
	          prepStmt.close();
	          
	          System.out.println("----");
	          
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
