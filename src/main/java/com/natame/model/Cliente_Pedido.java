package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Cliente_Pedido {
	
	@Column(name = "IDPEDIDO")
	@Id
	private int IDPEDIDO;
	
	//LEFT TYPE OF RELATIONSHIP
	@JoinColumn(name = "CEDULA", referencedColumnName = "CEDULA")
	private Cliente cliente;
	
	@Column(name = "FECHAPEDIDO")
	private String FECHAPEDIDO;
}
