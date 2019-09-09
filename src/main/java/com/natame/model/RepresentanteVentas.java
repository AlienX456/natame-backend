package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

public class RepresentanteVentas {
	@Column(name = "IDREGION")
	@Id
	private int IDENTIFICACION;
	
	@Column(name = "NOMBRE", nullable = false, length = 50)
	private String NOMBRE;
	
	@Column(name = "CORREOELECTRONICO", nullable = false, length = 50)
	private String CORREOELECTRONICO;
	
	@Column(name = "GENERO", nullable = false, length = 50)
	private String GENERO;
	
	@Column(name = "FECHANACIMIENTO", nullable = false, length = 50)
	private String FECHANACIMIENTO;
	
	@Column(name = "FECHACONTRATO", nullable = false, length = 50)
	private String FECHACONTRATO;
	
	@Column(name = "TELEFONOCONTACTO", nullable = false, length = 50)
	private String TELEFONOCONTACTO;
	
	@Column(name = "DIRECCION", nullable = false, length = 50)
	private String DIRECCION;
	
	@Column(name = "ESDIRETOR", nullable = false)
	private int ESDIRETOR;
	
	//LEFT
	@JoinColumn(name = "IDGRADO", referencedColumnName = "IDGRADO")
	private Grado grado;
	
	//LEFT
	@JoinColumn(name = "IDREGION", referencedColumnName = "IDREGION")
	private Region region;
}
