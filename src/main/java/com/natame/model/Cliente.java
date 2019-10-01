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

	private int RP;
	


	public int getRP() {
		return RP;
	}

	public void setRP(int rP) {
		RP = rP;
	}

	public int getCEDULA() {
		return CEDULA;
	}

	public void setCEDULA(int cEDULA) {
		CEDULA = cEDULA;
	}

	public String getNOMBRECLIENTE() {
		return NOMBRECLIENTE;
	}

	public void setNOMBRECLIENTE(String nOMBRECLIENTE) {
		NOMBRECLIENTE = nOMBRECLIENTE;
	}

	public String getAPELLIDOCLIENTE() {
		return APELLIDOCLIENTE;
	}

	public void setAPELLIDOCLIENTE(String aPELLIDOCLIENTE) {
		APELLIDOCLIENTE = aPELLIDOCLIENTE;
	}

	public String getTELEFONO() {
		return TELEFONO;
	}

	public void setTELEFONO(String tELEFONO) {
		TELEFONO = tELEFONO;
	}

	public String getDIRECCION() {
		return DIRECCION;
	}

	public void setDIRECCION(String dIRECCION) {
		DIRECCION = dIRECCION;
	}

	public String getCIUDAD() {
		return CIUDAD;
	}

	public void setCIUDAD(String cIUDAD) {
		CIUDAD = cIUDAD;
	}

	public String getCORREOELECTRONICO() {
		return CORREOELECTRONICO;
	}

	public void setCORREOELECTRONICO(String cORREOELECTRONICO) {
		CORREOELECTRONICO = cORREOELECTRONICO;
	}
	
	
}
