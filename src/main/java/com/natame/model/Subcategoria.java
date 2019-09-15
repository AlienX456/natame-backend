package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Subcategoria {
	
	@Column(name = "PK_N_IDSUBCATEGORIA")
	@Id
	private int IDSUBCATEGORIA;
	
	@Column(name="V_NOMBREGRADO", nullable = false, length=50)
	private String NOMBRESUBCATEGORIA;
	
	@Column(name="DESCRIPCIONSUBCATEGORIA", nullable = true, length=50)
	private String DESCRIPCIONSUBCATEGORIA;
	
	//LEFT
	@ManyToOne
	@JoinColumn(name = "FK_N_IDCATEGORIA", referencedColumnName = "PK_N_IDCATEGORIA")
	private Categoria categoria;
}
