package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class RepresentanteVentas_Cliente {
	
	@Column(name = "ID")
	@Id
	private int ID;
	
	@Column(name="FECHAINICIO", length=50, nullable = false)
	private String FECHAINICIO;
	
	@Column(name="FECHAFIN", length=50, nullable = true)
	private String FECHAFIN;
	
	@ManyToOne
	@JoinColumn(name = "ID_REPRESENTANTE", referencedColumnName = "IDENTIFICACION")
	private RepresentanteVentas representante;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE", referencedColumnName = "CEDULA")
	private Cliente cliente;
	

}
