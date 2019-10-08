package com.natame.dao;

import com.natame.auth.Usuario;
import com.natame.model.Venta;
import com.natame.util.RHException;

public interface IComisionDao {
	public Venta[] obtenerVentaxComisionTotal(String finicio, String ffinal, Usuario user) throws RHException;
	public int obtenerValorTotal(int representanteVentas, Usuario user) throws RHException;
}
