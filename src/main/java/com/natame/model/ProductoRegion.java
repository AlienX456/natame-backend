package com.natame.model;

public class ProductoRegion {
	
	private int INVENTARIO;
	
	private int PRODUCTO;
	
	private String NOMBREPRODUCTO;
	
	private int CANTIDAD;
	
	private int PRECIO;
	
	private String NOMBREIMAGEN;
	
	

	public ProductoRegion(int iDPRODUCTOREGION, int iDPRODUCTO, String nOMBREPRODUCTO, int cANTIDAD, int pRECIO, String nOMBREIMAGEN) {
		setINVENTARIO(iDPRODUCTOREGION);
		setPRODUCTO(iDPRODUCTO);
		NOMBREPRODUCTO = nOMBREPRODUCTO;
		CANTIDAD = cANTIDAD;
		PRECIO = pRECIO;
		NOMBREIMAGEN = nOMBREIMAGEN;
	}

	public String getNOMBREIMAGEN() {
		return NOMBREIMAGEN;
	}

	public void setNOMBREIMAGEN(String nOMBREIMAGEN) {
		NOMBREIMAGEN = nOMBREIMAGEN;
	}

	public int getCANTIDAD() {
		return CANTIDAD;
	}

	public void setCANTIDAD(int cANTIDAD) {
		CANTIDAD = cANTIDAD;
	}

	public int getPRECIO() {
		return PRECIO;
	}

	public void setPRECIO(int pRECIO) {
		PRECIO = pRECIO;
	}

	public String getNOMBREPRODUCTO() {
		return NOMBREPRODUCTO;
	}

	public void setNOMBREPRODUCTO(String nOMBREPRODUCTO) {
		NOMBREPRODUCTO = nOMBREPRODUCTO;
	}

	public int getINVENTARIO() {
		return INVENTARIO;
	}

	public void setINVENTARIO(int iNVENTARIO) {
		INVENTARIO = iNVENTARIO;
	}

	public int getPRODUCTO() {
		return PRODUCTO;
	}

	public void setPRODUCTO(int pRODUCTO) {
		PRODUCTO = pRODUCTO;
	}
	
	
	
}
