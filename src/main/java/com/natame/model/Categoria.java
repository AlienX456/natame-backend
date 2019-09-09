package com.natame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categoria")
public class Categoria {
	
	@Column(name = "IDCATEGORIA")
	@Id
	private int IDCATEGORIA;

	@Column(name = "NOMBRECATEGORIA", nullable=true, length=50)
	private String NOMBRECATEGORIA;
}
