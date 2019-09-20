package com.natame.dao;

import com.natame.auth.Usuario;
import com.natame.model.ProductoRegion;
import com.natame.util.RHException;

public interface IProductoRegionDao {
	public ProductoRegion[] buscarProductoxRegion( int region, Usuario user) throws RHException;
}
