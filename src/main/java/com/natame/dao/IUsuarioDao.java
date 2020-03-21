package com.natame.dao;
import com.natame.util.RHException;
import com.natame.auth.Usuario;
import com.natame.model.UsuarioPagos;

public interface IUsuarioDao {
	public void registrarUsuario(Usuario user, UsuarioPagos userp) throws RHException;
	public UsuarioPagos obtenerUsuario(Usuario user, int id) throws RHException;
}
