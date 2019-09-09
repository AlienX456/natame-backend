package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Impuesto {
	
	@Column(name="IDIMPUESTO")
	@Id
	private int IDIMPUESTO;
	
	@Column(name="IVA", nullable=false)
	private float IVA;
	
	@Column(name="TIPOPRODUCTO", nullable=true)
	private float TIPOPRODUCTO;
	
	@Column(name="FECHAINICIO", nullable=true)
	private String FECHAINICIO;
	
	@Column(name="FECHAFINAL", nullable=true)
	private String FECHAFINAL;
	
	
}
