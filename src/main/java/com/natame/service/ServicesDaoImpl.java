package com.natame.service;


import org.springframework.stereotype.Service;

import com.natame.auth.BasicAuthConfig;
import com.natame.auth.Usuario;
import com.natame.dao.ClienteDaoOracle;
import com.natame.dao.IClienteDao;
import com.natame.dao.IPaisDao;
import com.natame.dao.IRepresentanteVentasDao;
import com.natame.dao.PaisDaoOracle;
import com.natame.dao.RepresentanteVentasDaoOracle;
import com.natame.model.Cliente;
import com.natame.model.Pais;
import com.natame.model.RepresentanteVentas;
import com.natame.util.RHException;


@Service
public class ServicesDaoImpl {
	
	//INTERFACES DAO
	private IPaisDao ipais;
	private IClienteDao icliente;
	private IRepresentanteVentasDao irp;
	
	private BasicAuthConfig bauth;
	
	public ServicesDaoImpl(){
		this.ipais = new PaisDaoOracle();
		this.bauth = new BasicAuthConfig();
		this.icliente = new ClienteDaoOracle();
		this.irp = new RepresentanteVentasDaoOracle();
	}
	
	
	/*
	 * PAIS
	 * 
	 * 
	 * 
	 * 
	 */
	
    public void incluirPais(Pais pais, String auth) throws RHException{
    	Usuario usuario = bauth.getUserPassword(auth);
		ipais.incluirPais(pais, usuario);
    }
    
    
    public void modificarPais(int id, String nombre, String auth) throws RHException {
    	Pais actual = new Pais(id,nombre);
		Usuario usuario = bauth.getUserPassword(auth);
		ipais.modificarPais(actual,usuario);
    	
    }
    
    
    public Pais buscarPais(Integer pais_id, String auth) throws RHException {
    	Pais resultado;
    	Usuario usuario = bauth.getUserPassword(auth);
		resultado = ipais.buscarPais(pais_id, usuario);
		return resultado;
    }
    
    
    public void borrarPais(Integer pais_id, String auth) throws RHException {
		Usuario usuario = bauth.getUserPassword(auth);
		ipais.borrarPais(pais_id, usuario);

    }
    
    
    public Pais[] verPaises(String auth) throws RHException {
    		Usuario usuario = bauth.getUserPassword(auth);
			return ipais.verPaises(usuario);
    }
    
    /*
     * 
     * CLIENTE
     * 
     * 
     * 
     */
    
    public Cliente buscarCliente(int cedula, String auth) throws RHException {
    	Usuario usuario = bauth.getUserPassword(auth);
    	return this.icliente.buscarCliente(cedula, usuario);
    }
    
    
    /*
     * 
     * REPRESENTANTE DE VENTAS
     * 
     * 
     * 
     */
    
    public void registrarRepresentanteVentas(RepresentanteVentas rp, String auth) throws RHException {
    	Usuario usuario = bauth.getUserPassword(auth);
    	this.irp.registrarRepresentanteVentas(rp, usuario);
    }
    
    public RepresentanteVentas buscarRepresentanteVentas(int identificacion, String auth) throws RHException {
    	Usuario usuario = bauth.getUserPassword(auth);
    	return this.irp.buscarRepresentanteVentas(identificacion, usuario);
    }
    
}
