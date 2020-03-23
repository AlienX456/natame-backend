package com.natame.model;

public class Pedido {

	private int PEDIDO;
	private String ESTADOPEDIDO;
	private int CALIFICACION;
	private String FPEDIDO;
	private String MODOPAGO;
	private int VALOR;
	private int ASOCIACION;
	
	
	public Pedido(int pEDIDO, String eSTADOPEDIDO, int cALIFICACION, String fPEDIDO, String mODOPAGO, int vALOR,
			int aSOCIACION) {
		super();
		PEDIDO = pEDIDO;
		ESTADOPEDIDO = eSTADOPEDIDO;
		CALIFICACION = cALIFICACION;
		FPEDIDO = fPEDIDO;
		MODOPAGO = mODOPAGO;
		VALOR = vALOR;
		ASOCIACION = aSOCIACION;
	}
	
	public int getPEDIDO() {
		return PEDIDO;
	}
	public void setPEDIDO(int pEDIDO) {
		PEDIDO = pEDIDO;
	}
	public String getESTADOPEDIDO() {
		return ESTADOPEDIDO;
	}
	public void setESTADOPEDIDO(String eSTADOPEDIDO) {
		ESTADOPEDIDO = eSTADOPEDIDO;
	}
	public int getCALIFICACION() {
		return CALIFICACION;
	}
	public void setCALIFICACION(int cALIFICACION) {
		CALIFICACION = cALIFICACION;
	}
	public String getFPEDIDO() {
		return FPEDIDO;
	}
	public void setFPEDIDO(String fPEDIDO) {
		FPEDIDO = fPEDIDO;
	}
	public String getMODOPAGO() {
		return MODOPAGO;
	}
	public void setMODOPAGO(String mODOPAGO) {
		MODOPAGO = mODOPAGO;
	}
	public int getVALOR() {
		return VALOR;
	}
	public void setVALOR(int vALOR) {
		VALOR = vALOR;
	}
	public int getASOCIACION() {
		return ASOCIACION;
	}
	public void setASOCIACION(int aSOCIACION) {
		ASOCIACION = aSOCIACION;
	}
	
	
}
