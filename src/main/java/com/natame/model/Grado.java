package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Grado {

	@Column(name = "IDGRADO")
	@Id
	private int IDPGRADO;
	
	@Column(name="NOMBREGRADO", length=50)
	private String NOMBREGRADO;
	
	@Column(name="DESCRIPCIONGRADO", length=50)
	private String DESCRIPCIONGRADO;
}
