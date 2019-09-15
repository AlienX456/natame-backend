package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {
	
	@Column(name = "PK_N_CEDULA")
	@Id
	private int CEDULA;
	
	
	@Column(name = "V_NOMBRECLIENTE", nullable = false, length=50)
	private String NOMBRECLIENTE;
	
	@Column(name = "V_APELLIDOCLIENTE", nullable = false, length=50)
	private String APELLIDOCLIENTE;
	
	@Column(name = "V_TELEFONO", nullable = false, length=50)
	private String TELEFONO;
	
	@Column(name = "V_DIRECCION", nullable = false, length=50)
	private String DIRECCION;
	
	@Column(name = "V_CIUDAD", nullable = false, length=50)
	private String CIUDAD;
	
	@Column(name = "V_CORREOELECTRONICO", nullable = true, length=50)
	private String CORREOELECTRONICO;
}
