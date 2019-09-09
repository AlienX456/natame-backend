package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {
	
	@Column(name = "CEDULA")
	@Id
	private int CEDULA;
	
	
	@Column(name = "NOMBRECLIENTE", nullable = true, length=50)
	private String NOMBRECLIENTE;
	
	@Column(name = "APELLIDOCLIENTE", nullable = true, length=50)
	private String APELLIDOCLIENTE;
	
	@Column(name = "TELEFONO", nullable = true, length=50)
	private String TELEFONO;
	
	@Column(name = "DIRECCION", nullable = true, length=50)
	private String DIRECCION;
	
	@Column(name = "CIUDAD", nullable = true, length=50)
	private String CIUDAD;
	
	@Column(name = "CORREOELECTRONICO", nullable = true, length=50)
	private String CORREOELECTRONICO;
}
