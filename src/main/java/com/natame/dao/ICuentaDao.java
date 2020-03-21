package com.natame.dao;
import com.natame.util.RHException;
import com.natame.auth.Usuario;
import com.natame.model.Cuenta;

public interface ICuentaDao {
	public void registrarCuenta(Usuario user, Cuenta cuenta) throws RHException;
	public Cuenta obtenerCuenta(Usuario user, int id) throws RHException;
}
