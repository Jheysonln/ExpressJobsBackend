package com.expressJobs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Provincia")
public class Provincia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProv;
	private String provincia;
	private Long idDepa;
	
	public Long getIdProv() {
		return idProv;
	}
	public void setIdProv(Long idProv) {
		this.idProv = idProv;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Long getIdDepa() {
		return idDepa;
	}
	public void setIdDepa(Long idDepa) {
		this.idDepa = idDepa;
	}
}
