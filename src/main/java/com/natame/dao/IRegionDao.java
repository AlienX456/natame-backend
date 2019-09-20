package com.natame.dao;

import com.natame.auth.Usuario;
import com.natame.model.Region;
import com.natame.util.RHException;

public interface IRegionDao {
	public Region[] verRegiones(Usuario user) throws RHException;
}
