package com.expressJobs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
<<<<<<< HEAD
=======
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
>>>>>>> a10ac3efd97f7c46ba6c422bc06b16e7d5717e26
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "especialidad")
public class Especialidad {
<<<<<<< HEAD

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
=======
	
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
>>>>>>> a10ac3efd97f7c46ba6c422bc06b16e7d5717e26
