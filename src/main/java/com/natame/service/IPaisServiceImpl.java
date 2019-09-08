package com.natame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natame.repository.IPaisRepo;

@Service
public class IPaisServiceImpl implements IPaisService {
	
	@Autowired
	private IPaisRepo paisrepo;

	@Override
	public void registrarPais(String nombre) {
		this.paisrepo.registrarPais("Colombia");
		
	}

}
