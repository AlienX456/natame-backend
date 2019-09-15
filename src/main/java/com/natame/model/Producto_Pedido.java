package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Producto_Pedido {

	@Column(name="PK_N_IDDETALLE")
	@Id
	private int ID_DETALLE;
	
	@Column(name="N_CANTIDAD", nullable=false)
	private int CANTIDAD;
	
	@ManyToOne
	@JoinColumn(name = "FK_N_IDPEDIDO", referencedColumnName = "PK_N_IDPEDIDO", nullable = false)
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "FK_N_IDPRODUCTO", referencedColumnName = "PK_N_IDPRODUCTO", nullable = false)
	private Producto producto;
}
