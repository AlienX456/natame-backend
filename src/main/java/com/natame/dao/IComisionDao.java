package com.natame.dao;

import com.natame.auth.Usuario;
import com.natame.util.RHException;

public interface IComisionDao {
	public int obtenerValorComisionTotal(int representanteVentas, Usuario user) throws RHException;
}
