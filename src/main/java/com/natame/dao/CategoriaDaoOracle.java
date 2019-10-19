package com.natame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.natame.auth.Usuario;
import com.natame.model.Subcategoria;
import com.natame.util.RHException;
import com.natame.util.ServiceLocator;

public class CategoriaDaoOracle implements ICategoriaDao{

	@Override
	public Subcategoria[] obtenerCategorias(Usuario user) throws RHException {
		ArrayList<Subcategoria> lista = new ArrayList<Subcategoria>();
		try {
			String strSQL = "SELECT * FROM SUBCATEGORIA";
			Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
	        ResultSet rs = prepStmt.executeQuery();
	        while(rs.next()) {
	        	lista.add(new Subcategoria(rs.getInt("K_SUBCATEGORIA"),rs.getString("C_NOMBRE"),rs.getString("D_RESUMEN"),rs.getInt("K_CATEGORIA")));
	        }
	        prepStmt.close();
			}catch (Exception e) {
	    	   throw new RHException( this.getClass().getName(), "Error en verPaises() "+ e.getMessage());
			}finally {
			  ServiceLocator.getInstance().liberarConexion(); 
	       }
			return lista.toArray(new Subcategoria[lista.size()]);
	}

}
