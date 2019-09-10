package com.natame.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.natame.repository.IPaisRepo;

@Controller
public class ControllerAPI {
	
	@Autowired
	private IPaisRepo pais;
	
	@GetMapping("/paises")
	public String getPais() {
		return pais.findById(001).toString();
		
	}
	

}
