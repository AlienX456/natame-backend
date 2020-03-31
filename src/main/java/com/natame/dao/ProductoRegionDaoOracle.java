package com.natame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.natame.auth.Usuario;
import com.natame.model.ProductoRegion;
import com.natame.util.RHException;
import com.natame.util.ServiceLocator;

public class ProductoRegionDaoOracle implements IProductoRegionDao {

	@Override
	public ProductoRegion[] buscarProductoxRegion(int region, Usuario user) throws RHException {
		ArrayList<ProductoRegion> lista = new ArrayList<ProductoRegion>();
		try {
			String strSQL = "SELECT * FROM INVENTARIOVIEW WHERE K_REGION=?";
			Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			prepStmt.setInt(1,region);
	        ResultSet rs = prepStmt.executeQuery();
	        while(rs.next()) {
	        	lista.add(new ProductoRegion(rs.getInt("K_INVENTARIO"),rs.getInt("K_PRODUCTO")
	        			, rs.getString("C_NOMBRE"), rs.getInt("N_CANTIDAD"), rs.getInt("T_PRECIO"),rs.getString("V_NOMBREIMAGEN"),
	        			rs.getFloat("T_IMPUESTO")));
	        }
	        prepStmt.close();
	        return lista.toArray(new ProductoRegion[lista.size()]);
			}catch (Exception e) {
	    	   throw new RHException( this.getClass().getName(), "Error en buscarProductoxRegion() "+ e.getMessage());
			}finally {
			  ServiceLocator.getInstance().liberarConexion(); 
	       }			
	}

}
