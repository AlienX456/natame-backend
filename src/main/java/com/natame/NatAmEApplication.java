package com.natame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.natame.service.IPaisService;

@SpringBootApplication
public class NatAmEApplication implements CommandLineRunner{
	
	@Autowired
	private IPaisService service;
	
	public static void main(String[] args) {
		SpringApplication.run(NatAmEApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
