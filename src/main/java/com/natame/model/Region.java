package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Region {
	
	@Column(name = "PK_N_IDREGION")
	@Id
	private int IDREGION;
	
	@Column(name = "V_NOMBREREGION", nullable = false, length = 50)
	private String NOMBREREGION;
	
	//LEFT
	@ManyToOne
	@JoinColumn(name = "FK_N_IDPAIS", referencedColumnName = "PK_N_IDPAIS")
	private Pais pais;
	
}
