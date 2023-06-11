package com.expressJobs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "especialidad")
public class Especialidad {
	
	@Id
	@Column(name = "id_especialidad")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_especialidad;

	@Column(name = "nom_especialidad")
	private String nom_especialidad;

	public Especialidad() {

	}
	
	public Especialidad(Long id_especialidad, String nom_especialidad) {
		super();
		this.id_especialidad = id_especialidad;
		this.nom_especialidad = nom_especialidad;
	}

	public Long getId_especialidad() {
		return id_especialidad;
	}

	public void setId_especialidad(Long id_especialidad) {
		this.id_especialidad = id_especialidad;
	}

	public String getNom_especialidad() {
		return nom_especialidad;
	}

	public void setNom_especialidad(String nom_especialidad) {
		this.nom_especialidad = nom_especialidad;
	}
	
	
	
}	
