package com.natame.dao;

import com.natame.auth.Usuario;
import com.natame.model.Pais;
import com.natame.util.RHException;

public interface IPaisDao {
	    public void incluirPais(Pais pais, Usuario user) throws RHException;
	    public void modificarPais(Pais pais, Usuario user) throws RHException;
	    public Pais buscarPais(Integer pais_id, Usuario user) throws RHException;
	    public void borrarPais(Integer pais_id, Usuario user) throws RHException;
	    public Pais[] verPaises(Usuario user) throws RHException;
}
