package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Producto_Pedido {

	@Column(name="ID_DETALLE")
	@Id
	private int ID_DETALLE;
	
	@Column(name="CANTIDAD", nullable=true)
	private int CANTIDAD;
	
	@ManyToOne
	@JoinColumn(name = "IDPEDIDO", referencedColumnName = "IDPEDIDO")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "IDPRODUCTO", referencedColumnName = "IDPRODUCTO")
	private Producto producto;
}
