package com.expressJobs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PrefijoTelefono")
public class PrefijoTelefono {

	// Cambio de prueba por Jhoel
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrefijo;
	private String prefijo;
	private String Pais;
	
	public Long getIdPrefijo() {
		return idPrefijo;
	}
	public void setIdPrefijo(Long idPrefijo) {
		this.idPrefijo = idPrefijo;
	}
	public String getPrefijo() {
		return prefijo;
	}
	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}
	public String getPais() {
		return Pais;
	}
	public void setPais(String pais) {
		Pais = pais;
	}
}
