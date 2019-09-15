package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class RepresentanteVentas {
	@Column(name = "PK_N_IDENTIFICACION")
	@Id
	private int IDENTIFICACION;
	
	@Column(name = "V_NOMBRE", nullable = false, length = 50)
	private String NOMBRE;
	
	@Column(name = "V_CORREOELECTRONICO", nullable = true)
	private String CORREOELECTRONICO;
	
	@Column(name = "V_GENERO", nullable = false, length = 1)
	private String GENERO;
	
	@Column(name = "D_FECHANACIMIENTO", nullable = false)
	private String FECHANACIMIENTO;
	
	@Column(name = "D_FECHACONTRATO", nullable = false)
	private String FECHACONTRATO;
	
	@Column(name = "V_TELEFONOCONTACTO", nullable = false, length = 12)
	private String TELEFONOCONTACTO;
	
	@Column(name = "V_DIRECCION", nullable = false, length = 30)
	private String DIRECCION;
	
	@Column(name = "V_ESDIRETOR", nullable = false, length = 1)
	private int ESDIRETOR;
	
	//LEFT
	@ManyToOne
	@JoinColumn(name = "FK_N_IDGRADO", nullable = false, referencedColumnName = "PK_N_IDGRADO")
	private Grado grado;
	
	//LEFT
	@ManyToOne
	@JoinColumn(name = "FK_N_IDREGION", nullable = false, referencedColumnName = "PK_N_IDREGION")
	private Region region;
}
