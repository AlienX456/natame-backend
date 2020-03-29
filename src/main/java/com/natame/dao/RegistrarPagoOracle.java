package com.natame.dao;
import com.natame.auth.Usuario;
import com.natame.util.RHException;
import com.natame.util.ServiceLocator;
import java.sql.Connection;
import java.sql.Types;
import java.sql.CallableStatement;

public class RegistrarPagoOracle implements IRegistrarPago{

	@Override
	public String registrarPago(int id_pedido, Usuario user) throws RHException {
		try {
			String llamado = "{ ? = call PK_FACTURA.FU_PAGAR_EN_LINEA( ?, ?, ?) }";
			Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
			CallableStatement callStmt = conexion.prepareCall(llamado);
			callStmt.registerOutParameter(1,Types.VARCHAR);
			callStmt.setInt(2, id_pedido);
			callStmt.registerOutParameter(3,Types.NUMERIC);
			callStmt.registerOutParameter(4,Types.VARCHAR);
	        callStmt.executeUpdate();
	        
	        String result = callStmt.getString(4);
	        callStmt.close();
	        ServiceLocator.getInstance().commit();
	        return result;
			} catch (Exception e) {
	      	  try {
		      		if (ServiceLocator.getInstance().getConexion()!=null) {
		                System.err.print("se enviara petición de Rollback");
		                ServiceLocator.getInstance().rollback();
		      		}
		        } catch(Exception excep) {
		        	throw new RHException( this.getClass().getName(), " Error en  registrarPago() ROLLBACK "+ excep.getMessage());
		        }
	        	throw new RHException( this.getClass().getName(), " Error en  registrarPago() "+ e.getMessage());
			}  finally {
	           ServiceLocator.getInstance().liberarConexion();
	        }
	}

}
