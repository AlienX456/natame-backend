package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pais {
	
	@Column(name="IDPAIS")
	@Id
	private int IDPAIS;
	
	@Column(name="NOMBREPAIS", nullable = false, length=50)
	private String NOMBREPAIS;
	
}
