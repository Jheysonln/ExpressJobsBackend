package com.expressJobs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prefijotelefono")
public class PrefTelefono {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idprefijo;
	private String prefijo;
	private String pais;

	public Long getIdprefijo() {
		return idprefijo;
	}

	public void setIdprefijo(Long idprefijo) {
		this.idprefijo = idprefijo;
	}

	public String getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
