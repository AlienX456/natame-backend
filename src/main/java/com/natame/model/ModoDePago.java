package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ModoDePago {
	
	@Column(name="IDMODODEPAGO")
	@Id
	private int IDMODODEPAGO;
	
	@Column(name="NOMBREMODODEPAGO", nullable=true)
	private String NOMBREMODODEPAGO;
}
