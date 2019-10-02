package com.natame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.natame.auth.Usuario;
import com.natame.util.RHException;
import com.natame.util.ServiceLocator;

public class ComisionDaoOracle implements IComisionDao{

	@Override
	public int obtenerValorComisionTotal(int representanteVentas, Usuario user) throws RHException {
		try {
			String strSQL = "SELECT SUM(V_VALOR*N_COMISION) AS TOTAL FROM GRADO G,REPRESENTANTEVENTAS_CLIENTE RC, REPRESENTANTEVENTAS R,PEDIDO P "
					+ "WHERE RC.FK_N_IDENTIFICACION=? AND G.PK_V_NOMREGRADO=R.FK_V_NOMBREGRADO AND RC.FK_N_IDENTIFICACION = R.PK_N_IDENTIFICACION "
					+ "AND P.FK_N_CEDULA=RC.FK_N_CEDULA";
			Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
			 
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			prepStmt.setInt(1, representanteVentas);
	        ResultSet rs = prepStmt.executeQuery();
	        rs.next();
	        int resultado = rs.getInt("TOTAL");
	        prepStmt.close();
	        System.out.println("--");
	        return resultado;
			}catch (Exception e) {
	    	   throw new RHException( this.getClass().getName(), "Error en obtenerValorComisionTotal() "+ e.getMessage());
			}  finally {
	          ServiceLocator.getInstance().liberarConexion();
	       }
	}
	
	@Override
	public int obtenerValorTotal(int representanteVentas, Usuario user) throws RHException {
		try {
			String strSQL = "SELECT SUM(V_VALOR) AS TOTAL FROM GRADO G,REPRESENTANTEVENTAS_CLIENTE RC, REPRESENTANTEVENTAS R,PEDIDO P "
					+ "WHERE RC.FK_N_IDENTIFICACION=? AND G.PK_V_NOMREGRADO=R.FK_V_NOMBREGRADO AND RC.FK_N_IDENTIFICACION = R.PK_N_IDENTIFICACION "
					+ "AND P.FK_N_CEDULA=RC.FK_N_CEDULA";
			Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
			 
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			prepStmt.setInt(1, representanteVentas);
	        ResultSet rs = prepStmt.executeQuery();
	        rs.next();
	        int resultado = rs.getInt("TOTAL");
	        prepStmt.close();
	        System.out.println("--");
	        return resultado;
			}catch (Exception e) {
	    	   throw new RHException( this.getClass().getName(), "Error en obtenerValorComisionTotal() "+ e.getMessage());
			}  finally {
	          ServiceLocator.getInstance().liberarConexion();
	       }
	}
	
}
