package com.natame.dao;

import com.natame.auth.Usuario;
import com.natame.model.Subcategoria;
import com.natame.util.RHException;

public interface ICategoriaDao {
	public Subcategoria[] obtenerCategorias(Usuario user) throws RHException;
}
