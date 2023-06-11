package com.expressJobs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prefijotelefono")
public class PrefTelefono {

	
	@Id
	@Column(name = "id_prefijo_telefono")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_prefijo_telefono;
	
	@Column(name = "prefijo_telefono")
	private String prefijo_telefono;
	
	@Column(name = "pais")
	private String pais;

	public PrefTelefono() {

	}
	
	public PrefTelefono(int id_prefijo_telefono, String prefijo_telefono, String pais) {
		super();
		this.id_prefijo_telefono = id_prefijo_telefono;
		this.prefijo_telefono = prefijo_telefono;
		this.pais = pais;
	}

	public int getId_prefijo_telefono() {
		return id_prefijo_telefono;
	}

	public void setId_prefijo_telefono(int id_prefijo_telefono) {
		this.id_prefijo_telefono = id_prefijo_telefono;
	}

	public String getPrefijo_telefono() {
		return prefijo_telefono;
	}

	public void setPrefijo_telefono(String prefijo_telefono) {
		this.prefijo_telefono = prefijo_telefono;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}


	

}
