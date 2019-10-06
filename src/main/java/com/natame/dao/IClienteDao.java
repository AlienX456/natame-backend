package com.natame.dao;

import com.natame.auth.Usuario;
import com.natame.model.Cliente;
import com.natame.util.RHException;

public interface IClienteDao {
    public Cliente buscarCliente(Usuario user) throws RHException;
    public Cliente[] listarClientesRV(Usuario user) throws RHException;
    public void registrarCliente(Cliente cliente,Usuario user) throws RHException;
}
