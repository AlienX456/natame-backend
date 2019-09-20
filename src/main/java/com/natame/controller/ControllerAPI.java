package com.natame.controller;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.natame.model.Pais;
import com.natame.model.RepresentanteVentas;
import com.natame.service.ServicesDaoImpl;
import com.natame.util.RHException;


@RestController
public class ControllerAPI {
	
	
	@Autowired
	private ServicesDaoImpl serviciosDao;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	/*
	 * PAISES
	 * REALIZADO CON FINES DE PRUEBA
	 */
	
	
	@RequestMapping(value = "/pais", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String obtenerPaises(@RequestHeader("Authorization") String auth){
		try {
			return objectMapper.writeValueAsString(this.serviciosDao.verPaises(auth));
		} catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
	}
	
	@RequestMapping(value = "/pais/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String obtenerPais(@PathVariable String id, @RequestHeader("Authorization") String auth) {
		try {
			int intid = Integer.parseInt(id);
			return objectMapper.writeValueAsString(serviciosDao.buscarPais(intid,auth));
		} catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
	}
	
	@RequestMapping(value = "/pais", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String insertarPais(@RequestBody Pais pais, @RequestHeader("Authorization") String auth) {
		try {
			serviciosDao.incluirPais(pais, auth);
			return "{\"resultado\":\"transacción finalizada con exito\"}";
		} catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
	}
	
	@RequestMapping(value = "/pais/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public String borrarPais(@PathVariable String id, @RequestHeader("Authorization") String auth) {
		try {
			int intid = Integer.parseInt(id);
			serviciosDao.borrarPais(intid, auth);
			return "{\"resultado\":\"transacción finalizada con exito\"}";
		}catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
	}
	
	/*
	POST BODY LIKE :
	{
	    "idpais": 4,
	    "nombrepais": "Canada"
	}
	*/
	
	/*CASO DE USO
	 * REGISTRAR RERESENTANTE DE VENTAS
	 * 
	 */
	
	
	@RequestMapping(value = "/cliente/{cedula}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String buscarCliente(@PathVariable String cedula, @RequestHeader("Authorization") String auth) {
		try {
			int intid = Integer.parseInt(cedula);
			return objectMapper.writeValueAsString(serviciosDao.buscarCliente(intid, auth));
		}catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
	}
	
	@RequestMapping(value = "/representante", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String registrarRepresentanteVentas(@RequestBody RepresentanteVentas rp, @RequestHeader("Authorization") String auth) {
		try {
			serviciosDao.registrarRepresentanteVentas(rp, auth);
			return "{\"resultado\":\"transacción finalizada con exito\"}";
		}catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
	}
	
	/*
	 * POST BODY LIKE :
	{
    "identificacion":1030675823,
    "nombre":"Esteban",
    "correoelectronico":"estebanelias27",
    "genero":"M",
    "fechanacimiento":"27-02-1997",
    "fechacontrato":"30-06-2019",
    "telefonocontacto":"3103018563",
    "direccion":"cll 40 a",
    "esdirector":"S",
    "grado":4,
    "region":1
	}
	 */
	
	@RequestMapping(value = "/representante/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String buscarRepresentanteVentas(@PathVariable String id, @RequestHeader("Authorization") String auth) {
		try {
			int identificacion = Integer.parseInt(id); 
			return objectMapper.writeValueAsString(serviciosDao.buscarRepresentanteVentas(identificacion, auth));
		}catch (Exception e) {
			return "{\"error\":\""+e+"\"}";
		}
	}
	
	
	


	

}
