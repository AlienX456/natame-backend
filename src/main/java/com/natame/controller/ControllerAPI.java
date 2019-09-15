package com.natame.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.natame.model.Pais;
import com.natame.repository.IPaisRepo;

@RestController
public class ControllerAPI {
	
	//ACCIONES SOBRE LOS PAISES
	
	@Autowired
	private IPaisRepo pais;
	
	@RequestMapping(value = "/pais", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String obtenerPaises() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(pais.findAll());
		return json;
	}
	
	@RequestMapping(value = "/pais/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String obtenerPais(@PathVariable String id) {
		int intid = Integer.parseInt(id);
		return pais.findById(intid).get().getNOMBREPAIS();
	}
	
	@RequestMapping(value = "/pais/{id}/{nombre}", method = RequestMethod.POST)
	@ResponseBody
	public String insertarPais(@PathVariable String id,@PathVariable String nombre) {
		int intid = Integer.parseInt(id);
		Pais nuevo = new Pais();
		nuevo.setIDPAIS(intid);
		nuevo.setNOMBREPAIS(nombre);
		pais.save(nuevo);
		return "Done";
	}
	

}
