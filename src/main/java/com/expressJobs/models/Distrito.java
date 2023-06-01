package com.expressJobs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "distrito")
public class Distrito {

	@Id
	@Column(name = "id_dist")
	private int id_dist;
	
	@Column(name = "nom_distrito")
	private String nom_distrito;
	
	@Column(name = "id_prov")
	private int id_prov;

	public Distrito() {
		
	}

	public Distrito(int id_dist, String nom_distrito, int id_prov) {
		this.id_dist = id_dist;
		this.nom_distrito = nom_distrito;
		this.id_prov = id_prov;
	}

	public int getId_dist() {
		return id_dist;
	}

	public void setId_dist(int id_dist) {
		this.id_dist = id_dist;
	}

	public String getNom_distrito() {
		return nom_distrito;
	}

	public void setNom_distrito(String nom_distrito) {
		this.nom_distrito = nom_distrito;
	}

	public int getId_prov() {
		return id_prov;
	}

	public void setId_prov(int id_prov) {
		this.id_prov = id_prov;
	}
}
