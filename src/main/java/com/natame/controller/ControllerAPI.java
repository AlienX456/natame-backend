package com.natame.controller;




import java.security.Principal;

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
import com.natame.service.ServicesDaoImpl;
import com.natame.util.RHException;


@RestController
public class ControllerAPI {
	
	
	@Autowired
	private ServicesDaoImpl serviciosDao;
	
	
	
	@RequestMapping(value = "/pais", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String obtenerPaises(@RequestHeader("Authorization") String auth){
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(this.serviciosDao.verPaises(auth));
		} catch (RHException e) {
			return "{\"error\":\""+e+"\"}";
		} catch (JsonProcessingException e) {
			return "{\"error\":\""+e+"\"}";
		}
	}
	
	@RequestMapping(value = "/pais/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String obtenerPais(@PathVariable String id, @RequestHeader("Authorization") String auth) {
		try {
			int intid = Integer.parseInt(id);
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.writeValueAsString(serviciosDao.buscarPais(intid,auth));
		} catch (RHException e) {
			return "{\"error\":\""+e+"\"}";
		}catch (JsonProcessingException e) {
			return "{\"error\":\""+e+"\"}";
		} 
	}
	
	@RequestMapping(value = "/pais", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String insertarPais(@RequestBody Pais pais, Principal principal, @RequestHeader("Authorization") String auth) {
		try {
			serviciosDao.incluirPais(pais, auth);
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.writeValueAsString(serviciosDao.buscarPais(pais.getIDPAIS(),auth));
		} catch (RHException e) {
			return "{\"error\":\""+e+"\"}";
		} catch (JsonProcessingException e) {
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
	
	//error


	

}
