package com.natame.model;


public class ClientePedido {
	private int CEDULA;
	private ProductoDetalle[] PD;
	


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
