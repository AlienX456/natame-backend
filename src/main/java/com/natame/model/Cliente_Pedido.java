package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cliente_Pedido {
	
	@Column(name = "PK_N_ID")
	@Id
	private int ID;
	
	//LEFT TYPE OF RELATIONSHIP
	@ManyToOne
	@JoinColumn(name = "FK_N_CEDULA", referencedColumnName = "PK_N_CEDULA")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "FK_N_IDPEDIDO", referencedColumnName = "PK_N_IDPEDIDO")
	private Pedido pedido;
	
	@Column(name = "D_FECHAPEDIDO", nullable = false)
	private String FECHAPEDIDO;
}
