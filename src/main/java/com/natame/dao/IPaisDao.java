package com.natame.dao;

import com.natame.model.Pais;
import com.natame.util.RHException;

public interface IPaisDao {
	    public void incluirPais(Pais pais) throws RHException;
	    public void modificarPais(Pais pais) throws RHException;
	    public Pais buscarPais(Integer pais_id) throws RHException;
	    public void borrarPais(Integer pais_id) throws RHException;
	    public Pais[] verPaises() throws RHException;
}
