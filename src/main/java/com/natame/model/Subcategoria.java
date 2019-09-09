package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

public class Subcategoria {
	
	@Column(name = "IDSUBCATEGORIA")
	@Id
	private int IDSUBCATEGORIA;
	
	@Column(name="NOMBREGRADO", nullable = false, length=50)
	private String NOMBRESUBCATEGORIA;
	
	@Column(name="DESCRIPCIONSUBCATEGORIA", nullable = false, length=50)
	private String DESCRIPCIONSUBCATEGORIA;
	
	//LEFT
	@JoinColumn(name = "IDCATEGORIA", referencedColumnName = "IDCATEGORIA")
	private Categoria categoria;
}
