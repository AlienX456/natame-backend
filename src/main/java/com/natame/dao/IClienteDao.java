package com.natame.dao;

import com.natame.auth.Usuario;
import com.natame.model.Cliente;
import com.natame.util.RHException;

public interface IClienteDao {
    public Cliente buscarCliente(int cedula, Usuario user) throws RHException;
}
