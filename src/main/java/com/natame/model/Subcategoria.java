package com.natame.model;

public class Subcategoria {
	private int SUBCATEGORIA;
	private String NOMBRE;
	private String RESUMEN;
	private int CATEGORIA;
	
	
	public Subcategoria(int sUBCATEGORIA, String nOMBRE, String rESUMEN, int cATEGORIA) {
		SUBCATEGORIA = sUBCATEGORIA;
		NOMBRE = nOMBRE;
		RESUMEN = rESUMEN;
		CATEGORIA = cATEGORIA;
	}
	
	public int getSUBCATEGORIA() {
		return SUBCATEGORIA;
	}
	public void setSUBCATEGORIA(int sUBCATEGORIA) {
		SUBCATEGORIA = sUBCATEGORIA;
	}
	public String getNOMBRE() {
		return NOMBRE;
	}
	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}
	public String getRESUMEN() {
		return RESUMEN;
	}
	public void setRESUMEN(String rESUMEN) {
		RESUMEN = rESUMEN;
	}
	public int getCATEGORIA() {
		return CATEGORIA;
	}
	public void setCATEGORIA(int cATEGORIA) {
		CATEGORIA = cATEGORIA;
	}
	
	
}
