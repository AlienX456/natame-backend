package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ModoDePago {
	
	@Column(name="PK_N_IDMODODEPAGO")
	@Id
	private int IDMODODEPAGO;
	
	@Column(name="V_NOMBREMODODEPAGO", nullable=false)
	private String NOMBREMODODEPAGO;
}
