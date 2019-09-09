package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Producto_Pedido {

	@Column(name="ID_DETALLE")
	@Id
	private int ID_DETALLE;
	
	@Column(name="CANTIDAD", nullable=true)
	private int CANTIDAD;
	
	//LEFT
	@JoinColumn(name = "IDPEDIDO", referencedColumnName = "IDPEDIDO")
	private Pedido pedido;
	
	//LEFT
	@JoinColumn(name = "IDPRODUCTO", referencedColumnName = "IDPRODUCTO")
	private Producto producto;
}
