package com.expressJobs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provincia")
public class Provincia {

	@Id
	@Column(name = "id_provincia")
	private int id_provincia;
	
	@Column(name = "nom_provincia")
	private String nom_provincia;
	
	@Column(name = "id_depa")
	private int id_depa;

	public Provincia() {
	}

	public Provincia(int id_provincia, String nom_provincia, int id_depa) {
		this.id_provincia = id_provincia;
		this.nom_provincia = nom_provincia;
		this.id_depa = id_depa;
	}

	public int getId_provincia() {
		return id_provincia;
	}

	public void setId_provincia(int id_provincia) {
		this.id_provincia = id_provincia;
	}

	public String getNom_provincia() {
		return nom_provincia;
	}

	public void setNom_provincia(String nom_provincia) {
		this.nom_provincia = nom_provincia;
	}

	public int getId_depa() {
		return id_depa;
	}

	public void setId_depa(int id_depa) {
		this.id_depa = id_depa;
	}
}
