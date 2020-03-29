package com.natame.dao;
import com.natame.util.RHException;
import com.natame.auth.Usuario;

public interface IRegistrarPago {
	public String registrarPago(int id_pedido, Usuario user) throws RHException;
}
