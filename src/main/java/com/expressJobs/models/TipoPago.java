package com.expressJobs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoPago")
public class TipoPago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPago;
	private String descPago;
	
	public Long getIdPago() {
		return idPago;
	}
	public void setIdPago(Long idPago) {
		this.idPago = idPago;
	}
	public String getDescPago() {
		return descPago;
	}
	public void setDescPago(String descPago) {
		this.descPago = descPago;
	}
}
