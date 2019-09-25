package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Id;


public class Region {
	
	@Column(name = "PK_N_IDREGION")
	@Id
	private int IDREGION;
	
	@Column(name = "V_NOMBREREGION", nullable = false, length = 50)
	private String NOMBREREGION;
	
	/*//LEFT
	@ManyToOne
	@JoinColumn(name = "FK_N_IDPAIS", referencedColumnName = "PK_N_IDPAIS")
	private Pais pais;
	*/
	
	private int PAIS;

	public int getIDREGION() {
		return IDREGION;
	}

	public void setIDREGION(int iDREGION) {
		IDREGION = iDREGION;
	}

	public String getNOMBREREGION() {
		return NOMBREREGION;
	}

	public void setNOMBREREGION(String nOMBREREGION) {
		NOMBREREGION = nOMBREREGION;
	}

	public int getPAIS() {
		return PAIS;
	}

	public void setPAIS(int pAIS) {
		PAIS = pAIS;
	}

	public Region(int iDREGION, String nOMBREREGION, int pAIS) {
		IDREGION = iDREGION;
		NOMBREREGION = nOMBREREGION;
		PAIS = pAIS;
	}
	
	
}
