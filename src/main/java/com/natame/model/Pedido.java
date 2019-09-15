package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {
	
	@Column(name="PK_N_IDPEDIDO")
	@Id
	private int IDPEDIDO;
	
	@Column(name="ESTADOPEDIDO", nullable=false, length = 10)
	private String ESTADOPEDIDO;
	
	@Column(name="CALIFICACION", nullable=false,length = 50)
	private String CALIFICACION;
	
	@ManyToOne
	@JoinColumn(name = "FK_N_IDMODODEPAGO", referencedColumnName = "PK_N_IDMODODEPAGO")
	private ModoDePago mododepago;
	
}
