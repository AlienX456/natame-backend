package com.natame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.natame.auth.Usuario;
import com.natame.model.Venta;
import com.natame.util.RHException;
import com.natame.util.ServiceLocator;

public class ComisionDaoOracle implements IComisionDao{

	@Override
	public Venta[] obtenerVentaxComisionTotal(String finicio, String ffinal, Usuario user) throws RHException {
		try {
			ArrayList<Venta> lista = new ArrayList<Venta>();
			String strSQL = "SELECT A.K_IDRV,A.K_TIPOIDRV,SUM(T_VALOR) AS VENTA,SUM(T_VALOR*G.T_COMISIONVENTAS) AS COMISION " + 
					"FROM ASOCIACION A,REPRESENTANTEVENTAS RV, PEDIDO P, GRADORV G " + 
					"WHERE A.K_SECUENCIA = P.K_ASOCIACION AND G.K_GRADORV = RV.K_GRADORV " + 
					"AND A.K_IDRV = RV.K_IDENTIFICACION AND A.K_TIPOIDRV = RV.K_TIPOID " + 
					"AND P.F_PEDIDO BETWEEN TO_DATE(?,'DD-MM-YYYY') AND TO_DATE(?,'DD-MM-YYYY') " + 
					"GROUP BY A.K_IDRV,A.K_TIPOIDRV " + 
					"ORDER BY VENTA DESC";
			Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
			 
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			prepStmt.setString(1, finicio);
			prepStmt.setString(2, ffinal);
	        ResultSet rs = prepStmt.executeQuery();
	        while(rs.next()) {
	        	Venta resultado = new Venta();
	        	resultado.setID(rs.getInt("K_IDRV"));
	        	resultado.setTIPOID(rs.getString("K_TIPOIDRV"));
	        	resultado.setVENTA(rs.getDouble("VENTA"));
	        	resultado.setCOMISION(rs.getDouble("COMISION"));
	        	lista.add(resultado);
	        }
	        prepStmt.close();
	        System.out.println("--");
	        return lista.toArray(new Venta[lista.size()]);
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
