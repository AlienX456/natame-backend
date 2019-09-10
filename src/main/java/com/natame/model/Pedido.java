package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {
	
	@Column(name="IDPEDIDO")
	@Id
	private int IDPEDIDO;
	
	@Column(name="ESTADOPEDIDO", nullable=true, length = 50)
	private String ESTADOPEDIDO;
	
	@Column(name="CALIFICACION", nullable=true,length = 50)
	private String CALIFICACION;
	
	@ManyToOne
	@JoinColumn(name = "IDMODODEPAGO", referencedColumnName = "IDMODODEPAGO")
	private ModoDePago mododepago;
	
}
