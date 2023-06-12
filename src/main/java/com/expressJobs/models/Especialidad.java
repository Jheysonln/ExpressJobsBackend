package com.expressJobs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "especialidad")
public class Especialidad {

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "descripcion")
	private String descripcion;

	public Especialidad() {
		
	}

	public Especialidad(String id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}

