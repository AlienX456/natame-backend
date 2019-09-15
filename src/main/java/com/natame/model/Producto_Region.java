package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Producto_Region {
	
	@Column(name = "PK_N_IDPRODUCTOREGION")
	@Id
	private int IDPRODUCTOREGION;
	
	@Column(name = "PRECIO", nullable = false)
	private int PRECIO;
	
	@ManyToOne
	@JoinColumn(name = "FK_N_IDREGION", referencedColumnName = "PK_N_IDREGION", nullable = false)
	private Region region;
	
	@ManyToOne
	@JoinColumn(name = "FK_N_IDPRODUCTO", referencedColumnName = "PK_N_IDPRODUCTO", nullable = false)
	private Producto producto;

}
