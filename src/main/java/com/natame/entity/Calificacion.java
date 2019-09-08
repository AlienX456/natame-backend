package com.natame.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Calificacion")
public class Calificacion {
	
	@Column(name = "ID_CALIFICACION")
	@Id
	private int ID_CALIFICACION;
}
