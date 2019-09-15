package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categoria")
public class Categoria {
	
	@Column(name = "PK_N_IDCATEGORIA")
	@Id
	private int IDCATEGORIA;

	@Column(name = "V_NOMBRECATEGORIA", nullable=false, length=50)
	private String NOMBRECATEGORIA;
	
	@Column(name = "N_IVA", nullable=false)
	private float IVA;
}
