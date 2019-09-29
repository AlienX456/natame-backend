package com.natame.dao;

import com.natame.auth.Usuario;
import com.natame.model.ClientePedido;
import com.natame.util.RHException;

public interface IPedidoDao {
	public void realizarPedido(ClientePedido cp, Usuario user) throws RHException;
}
