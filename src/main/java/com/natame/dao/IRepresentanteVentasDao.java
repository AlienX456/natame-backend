package com.natame.dao;

import com.natame.auth.Usuario;
import com.natame.model.RepresentanteVentas;
import com.natame.util.RHException;

public interface IRepresentanteVentasDao {
	public void registrarRepresentanteVentas(RepresentanteVentas rp, Usuario user) throws RHException;
	public RepresentanteVentas buscarRepresentanteVentas(Usuario user) throws RHException;
}
