package com.natame.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClientePedido {
	private int identificacion;
	private String tipoid;
	private ProductoDetalle[] PD;
	
	private String ESTADO;
	private int CALIFICACION;
	private String FECHAPEDIDO;
	private String MODODEPAGO;
	
	ClientePedido(){
		setCALIFICACION(0);
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


	public ProductoDetalle[] getPD() {
		return PD;
	}

	public void setPD(ProductoDetalle[] pD) {
		PD = pD;
	}




	public int getIdentificacion() {
		return identificacion;
	}




	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}




	public String getTipoid() {
		return tipoid;
	}




	public void setTipoid(String tipoid) {
		this.tipoid = tipoid;
	}




	public int getCALIFICACION() {
		return CALIFICACION;
	}




	public void setCALIFICACION(int cALIFICACION) {
		CALIFICACION = cALIFICACION;
	}


	
	
}
