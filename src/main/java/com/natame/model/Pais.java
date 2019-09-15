package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class Pais {
	
	@Column(name="PK_N_IDPAIS")
	@Id
	private int IDPAIS;
	
	@Column(name="V_NOMBREPAIS", nullable = false, length=50)
	private String NOMBREPAIS;

	public int getIDPAIS() {
		return IDPAIS;
	}

	public void setIDPAIS(int iDPAIS) {
		IDPAIS = iDPAIS;
	}

	public String getNOMBREPAIS() {
		return NOMBREPAIS;
	}

	public void setNOMBREPAIS(String nOMBREPAIS) {
		NOMBREPAIS = nOMBREPAIS;
	}
	
	
	
}
