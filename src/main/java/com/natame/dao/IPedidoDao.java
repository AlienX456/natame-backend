package com.natame.dao;

import com.natame.auth.Usuario;
import com.natame.model.Pedido;
import com.natame.util.RHException;

public interface IPedidoDao {
	public Pedido[] obtenerListaPedidos(Usuario user) throws RHException;
	public void calificarPedido(int calificacion, int pedido, Usuario user) throws RHException;
}
