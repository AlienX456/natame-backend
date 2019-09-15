package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Producto_Subcategoria {
	
	@Column(name = "PK_N_ID")
	@Id
	private int ID;
	
	@Column(name="D_FECHACLASIFICACION", nullable = false)
	private String FECHACLASIFICACION;
	
	//LEFT
	@ManyToOne
	@JoinColumn(name = "FK_N_IDPRODUCTO", nullable = false,referencedColumnName = "PK_N_IDPRODUCTO")
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name = "FK_N_IDSUBCATEGORIA", nullable = false,referencedColumnName = "PK_N_IDSUBCATEGORIA")
	private Subcategoria subcategoria;

}
