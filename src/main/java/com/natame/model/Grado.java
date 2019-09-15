package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Grado {

	@Column(name = "PK_N_IDGRADO")
	@Id
	private int IDPGRADO;
	
	@Column(name="V_NOMBREGRADO", length=20, nullable = false)
	private String NOMBREGRADO;
	
	@Column(name="V_DESCRIPCIONGRADO", length=50, nullable = true)
	private String DESCRIPCIONGRADO;
}
