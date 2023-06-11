package com.expressJobs.request;

import javax.persistence.Column;

public class EspecialidadRequest {
	
	private Long id_especialidad;

	private String nom_especialidad;
	
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
