package com.natame.dao;

import com.natame.auth.Usuario;
import com.natame.model.NatameRolePrivs;
import com.natame.model.NatameUsrRole;
import com.natame.util.RHException;

public interface ISeguridadDao {
	
 public NatameRolePrivs[] obtenerPermisosXRol(Usuario user) throws RHException;
 public NatameUsrRole[] obtenerUsuariosXRol(Usuario user) throws RHException;
 
}
