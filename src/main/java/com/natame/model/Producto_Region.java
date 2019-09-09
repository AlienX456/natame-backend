package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

public class Producto_Region {
	
	@Column(name = "IDPRODUCTOREGION")
	@Id
	private int IDPRODUCTOREGION;
	
	@Column(name = "PRECIO")
	private int PRECIO;
	
	//LEFT
	@JoinColumn(name = "IDREGION", referencedColumnName = "IDREGION")
	private Region region;
	
	//LEFT
	@JoinColumn(name = "IDPRODUCTO", referencedColumnName = "IDPRODUCTO")
	private Producto producto;

}
