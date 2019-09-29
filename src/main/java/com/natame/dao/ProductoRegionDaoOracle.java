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
			String strSQL = "SELECT PR.PK_N_IDPRODUCTOREGION, P.PK_N_IDPRODUCTO, P.V_NOMBREPRODUCTO, PR.N_CANTIDAD, PR.N_PRECIO "
					+ "FROM PRODUCTO P, PRODUCTO_REGION PR "
					+ "WHERE PR.FK_N_IDPRODUCTO=P.PK_N_IDPRODUCTO "
					+ "AND PR.FK_N_IDREGION=? AND PR.N_CANTIDAD>0";
			Connection conexion = ServiceLocator.getInstance().tomarConexion(user);
			PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
			prepStmt.setInt(1,region);
	        ResultSet rs = prepStmt.executeQuery();
	        while(rs.next()) {
	        	lista.add(new ProductoRegion(rs.getInt("PK_N_IDPRODUCTOREGION"),rs.getInt("PK_N_IDPRODUCTO")
	        			, rs.getString("V_NOMBREPRODUCTO"), rs.getInt("N_CANTIDAD"), rs.getInt("N_PRECIO")));
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
