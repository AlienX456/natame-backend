package com.natame.service;


import org.springframework.stereotype.Service;

import com.natame.auth.BasicAuthConfig;
import com.natame.auth.Usuario;
import com.natame.dao.IPaisDao;
import com.natame.dao.PaisDaoOracle;
import com.natame.model.Pais;
import com.natame.util.RHException;
import com.natame.util.ServiceLocator;


@Service
public class ServicesDaoImpl {
	

	private IPaisDao ipais;
	
	private BasicAuthConfig bauth;
	
	private ServiceLocator servloc;
	
	public ServicesDaoImpl(){
		this.ipais = new PaisDaoOracle();
		this.bauth = new BasicAuthConfig();
		this.servloc = ServiceLocator.getInstance();
	}
	
    public void incluirPais(Pais pais, String auth) {
    	try {
			ipais.incluirPais(pais);
		} catch (RHException e) {
			e.printStackTrace();
		}
    	
    }
    public void modificarPais(int id, String nombre, String auth) {
    	Pais actual = new Pais(id,nombre);
    	try {
			ipais.modificarPais(actual);
		} catch (RHException e) {
			e.printStackTrace();
		}
    	
    }
    public Pais buscarPais(Integer pais_id, String auth) {
    	Pais resultado;
		try {
			resultado = ipais.buscarPais(pais_id);
			return resultado;
		} catch (RHException e) {
			e.printStackTrace();
			return null;
		}
		
		
    	
    }
    public void borrarPais(Integer pais_id, String auth) {
    	try {
			ipais.borrarPais(pais_id);
		} catch (RHException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public Pais[] verPaises(String auth) throws Exception {
    	try {
    		Usuario usuario = bauth.getUserPassword(auth);
    		servloc.usarCredencialesConexion(usuario.getNombre(), usuario.getContrasena());
			return ipais.verPaises();
		} catch (RHException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
}
