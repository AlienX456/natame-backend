package com.natame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.natame.auth.Usuario;
import com.natame.model.Region;
import com.natame.util.RHException;
import com.natame.util.ServiceLocator;

public class RegionDaoOracle implements IRegionDao{

	@Override
	public Region[] verRegiones(Usuario user) throws RHException {
		ArrayList<Region> lista = new ArrayList<Region>();
		try {
			String strSQL = "SELECT * FROM REGION";
			Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
	        ResultSet rs = prepStmt.executeQuery();
	        while(rs.next()) {
	        	lista.add(new Region(rs.getInt("K_REGION"),rs.getString("C_NOMBREREGION"),rs.getInt("K_PAIS")));
	        }
	        prepStmt.close();
	        return lista.toArray(new Region[lista.size()]);
			}catch (Exception e) {
	    	   throw new RHException( this.getClass().getName(), "Error en verRegiones() "+ e.getMessage());
			}finally {
			  ServiceLocator.getInstance().liberarConexion(); 
	       }
	}

}
