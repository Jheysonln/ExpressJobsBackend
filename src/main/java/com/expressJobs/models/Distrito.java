package com.expressJobs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Distrito")
public class Distrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDist;
	private String distrito;
	private Long idProv;
	
	public Long getIdDist() {
		return idDist;
	}
	public void setIdDist(Long idDist) {
		this.idDist = idDist;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public Long getIdProv() {
		return idProv;
	}
	public void setIdProv(Long idProv) {
		this.idProv = idProv;
	}
}
