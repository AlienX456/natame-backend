package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Id;

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
	private String ESDIRECTOR;
	
	@Column(name = "FK_N_IDGRADO", nullable = false, length = 1)
	private String GRADO;
	
	@Column(name = "FK_N_IDREGION", nullable = false, length = 1)
	private int REGION;
	
	private int RPM;
	
	
	
	//LEFT
	/*
	@ManyToOne
	@JoinColumn(name = "FK_N_IDGRADO", nullable = false, referencedColumnName = "PK_N_IDGRADO")
	private Grado grado;
	
	//LEFT
	@ManyToOne
	@JoinColumn(name = "FK_N_IDREGION", nullable = false, referencedColumnName = "PK_N_IDREGION")
	private Region region;
	*/

	public int getRPM() {
		return RPM;
	}

	public void setRPM(int rPM) {
		RPM = rPM;
	}

	public int getIDENTIFICACION() {
		return IDENTIFICACION;
	}

	public void setIDENTIFICACION(int iDENTIFICACION) {
		IDENTIFICACION = iDENTIFICACION;
	}

	public String getNOMBRE() {
		return NOMBRE;
	}

	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}

	public String getCORREOELECTRONICO() {
		return CORREOELECTRONICO;
	}

	public void setCORREOELECTRONICO(String cORREOELECTRONICO) {
		CORREOELECTRONICO = cORREOELECTRONICO;
	}

	public String getGENERO() {
		return GENERO;
	}

	public void setGENERO(String gENERO) {
		GENERO = gENERO;
	}

	public String getFECHANACIMIENTO() {
		return FECHANACIMIENTO;
	}

	public void setFECHANACIMIENTO(String fECHANACIMIENTO) {
		FECHANACIMIENTO = fECHANACIMIENTO;
	}

	public String getFECHACONTRATO() {
		return FECHACONTRATO;
	}

	public void setFECHACONTRATO(String fECHACONTRATO) {
		FECHACONTRATO = fECHACONTRATO;
	}

	public String getTELEFONOCONTACTO() {
		return TELEFONOCONTACTO;
	}

	public void setTELEFONOCONTACTO(String tELEFONOCONTACTO) {
		TELEFONOCONTACTO = tELEFONOCONTACTO;
	}

	public String getDIRECCION() {
		return DIRECCION;
	}

	public void setDIRECCION(String dIRECCION) {
		DIRECCION = dIRECCION;
	}

	public String getESDIRECTOR() {
		return ESDIRECTOR;
	}

	public void setESDIRECTOR(String eSDIRETOR) {
		ESDIRECTOR = eSDIRETOR;
	}

	public String getGRADO() {
		return GRADO;
	}

	public void setGRADO(String gRADO) {
		GRADO = gRADO;
	}

	public int getREGION() {
		return REGION;
	}

	public void setREGION(int rEGION) {
		REGION = rEGION;
	}

	
	
	
}
