package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

public class Region {
	
	@Column(name = "IDREGION")
	@Id
	private int IDREGION;
	
	@Column(name = "NOMBREREGION", nullable = false, length = 50)
	private String NOMBREREGION;
	
	//LEFT
	@JoinColumn(name = "IDPAIS", referencedColumnName = "IDPAIS")
	private Pais pais;
	
}
