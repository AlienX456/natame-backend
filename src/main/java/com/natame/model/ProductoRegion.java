package com.natame.model;

public class ProductoRegion {
	
	private int IDPRODUCTOREGION;
	
	private int IDPRODUCTO;
	
	private String NOMBREPRODUCTO;
	
	private int CANTIDAD;
	
	private int PRECIO;
	
	

	public ProductoRegion(int iDPRODUCTOREGION, int iDPRODUCTO, String nOMBREPRODUCTO, int cANTIDAD, int pRECIO) {
		IDPRODUCTOREGION = iDPRODUCTOREGION;
		IDPRODUCTO = iDPRODUCTO;
		NOMBREPRODUCTO = nOMBREPRODUCTO;
		CANTIDAD = cANTIDAD;
		PRECIO = pRECIO;
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

	public int getIDPRODUCTO() {
		return IDPRODUCTO;
	}

	public void setIDPRODUCTO(int iDPRODUCTO) {
		IDPRODUCTO = iDPRODUCTO;
	}

	public String getNOMBREPRODUCTO() {
		return NOMBREPRODUCTO;
	}

	public void setNOMBREPRODUCTO(String nOMBREPRODUCTO) {
		NOMBREPRODUCTO = nOMBREPRODUCTO;
	}

	public int getIDPRODUCTOREGION() {
		return IDPRODUCTOREGION;
	}

	public void setIDPRODUCTOREGION(int iDPRODUCTOREGION) {
		IDPRODUCTOREGION = iDPRODUCTOREGION;
	}
	
	
	
}
