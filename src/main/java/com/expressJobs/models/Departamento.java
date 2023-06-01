package com.expressJobs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departamento")
public class Departamento {

	@Id
	@Column(name = "id_Depa")
	private int id_Depa;

	@Column(name = "nom_departamento")
	private String nom_departamento;

	public Departamento() {
		
	}

	public Departamento(int idDepa, String nom_departamento) {
		this.id_Depa = idDepa;
		this.nom_departamento = nom_departamento;
	}

	public int getId_Depa() {
		return id_Depa;
	}

	public void setIdDepa(int id_Depa) {
		this.id_Depa = id_Depa;
	}

	public String getNom_departamento() {
		return nom_departamento;
	}

	public void setNom_departamento(String nom_departamento) {
		this.nom_departamento = nom_departamento;
	}
}
