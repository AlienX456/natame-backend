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
import com.natame.repository.IPaisRepo;
import com.natame.service.ServicesDaoImpl;


@RestController
public class ControllerAPI {
	
	//ACCIONES SOBRE LOS PAISES
	
	@Autowired
	private IPaisRepo pais;
	
	@Autowired
	private ServicesDaoImpl serviciosDao;
	
	
	
	@RequestMapping(value = "/pais", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String obtenerPaises(@RequestHeader("Authorization") String auth) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(this.serviciosDao.verPaises(auth));
		return json;
	}
	
	@RequestMapping(value = "/pais/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String obtenerPais(@PathVariable String id, @RequestHeader("Authorization") String auth) throws JsonProcessingException {
		int intid = Integer.parseInt(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(serviciosDao.buscarPais(intid,auth));
		return json;
	}
	
	@RequestMapping(value = "/pais", method = RequestMethod.POST)
	@ResponseBody
	public String insertarPais(@RequestBody Pais pais, Principal principal, @RequestHeader("Authorization") String auth) {
		serviciosDao.incluirPais(pais, auth);
		return "Mostrar errores en front";
	}
	

}
