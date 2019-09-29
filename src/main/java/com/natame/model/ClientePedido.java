package com.natame.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClientePedido {
	private int CEDULA;
	private ProductoDetalle[] PD;
	
	private String ESTADO;
	private String CALIFICACION;
	private String FECHAPEDIDO;
	private String MODODEPAGO;
	
	ClientePedido(){
		CALIFICACION = null;
		ESTADO = "GENERADO";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(dtf.format(LocalDateTime.now()));
		FECHAPEDIDO = dtf.format(LocalDateTime.now());
	}
	
	


	public String getESTADO() {
		return ESTADO;
	}




	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}




	public String getCALIFICACION() {
		return CALIFICACION;
	}




	public void setCALIFICACION(String cALIFICACION) {
		CALIFICACION = cALIFICACION;
	}




	public String getFECHAPEDIDO() {
		return FECHAPEDIDO;
	}




	public void setFECHAPEDIDO(String fECHAPEDIDO) {
		FECHAPEDIDO = fECHAPEDIDO;
	}




	public String getMODODEPAGO() {
		return MODODEPAGO;
	}




	public void setMODODEPAGO(String mODODEPAGO) {
		MODODEPAGO = mODODEPAGO;
	}




	public int getCEDULA() {
		return CEDULA;
	}

	public void setCEDULA(int cEDULA) {
		CEDULA = cEDULA;
	}

	public ProductoDetalle[] getPD() {
		return PD;
	}

	public void setPD(ProductoDetalle[] pD) {
		PD = pD;
	}


	
	
}
