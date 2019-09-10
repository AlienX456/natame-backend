package com.natame.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natame.model.Pais;
import com.natame.repository.IPaisRepo;

@RestController
public class NatameRestController {
	
	@Autowired
	private IPaisRepo repo_pais;
	
	@GetMapping
	public List<Pais> listar(){
		return repo_pais.findAll();
	}

}
