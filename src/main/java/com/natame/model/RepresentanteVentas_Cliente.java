package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class RepresentanteVentas_Cliente {
	
	@Column(name = "PK_N_ID")
	@Id
	private int ID;
	
	@Column(name="D_FECHAINICIO", nullable = false)
	private String FECHAINICIO;
	
	@Column(name="D_FECHAFIN", nullable = true)
	private String FECHAFIN;
	
	@ManyToOne
	@JoinColumn(name = "FK_N_IDENTIFICACION", referencedColumnName = "PK_N_IDENTIFICACION")
	private RepresentanteVentas representante;
	
	@ManyToOne
	@JoinColumn(name = "FK_N_CEDULA", referencedColumnName = "PK_N_CEDULA")
	private Cliente cliente;
	

}
