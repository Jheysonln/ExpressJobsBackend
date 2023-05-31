package com.expressJobs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoDocumento")
public class TipoDocumento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoDoc;
	private String documento;
	
	public Long getIdTipoDoc() {
		return idTipoDoc;
	}
	public void setIdTipoDoc(Long idTipoDoc) {
		this.idTipoDoc = idTipoDoc;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
}
