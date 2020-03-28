package com.natame.model;

public class Factura {
	
	private int CANTIDAD;
	private String NOMBRE;
	private float PRECIO;
	
	
	public Factura(int cANTIDAD, String nOMBRE, float pRECIO) {
		super();
		CANTIDAD = cANTIDAD;
		NOMBRE = nOMBRE;
		PRECIO = pRECIO;
	}
	
	public int getCANTIDAD() {
		return CANTIDAD;
	}
	public void setCANTIDAD(int cANTIDAD) {
		CANTIDAD = cANTIDAD;
	}
	public String getNOMBRE() {
		return NOMBRE;
	}
	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}
	public float getPRECIO() {
		return PRECIO;
	}
	public void setPRECIO(float pRECIO) {
		PRECIO = pRECIO;
	}
	
	
}
