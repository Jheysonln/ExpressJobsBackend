package com.expressJobs.request;

import java.sql.Date;

import javax.persistence.Column;

public class GenericoRequest {

	private Long id_generico_tabla;

	
	private String cod_tabla;
	

	private String cod_fila;
	
	
	private String desc_corta;
	
	
	private String desc_larga;
	
	
	private String valor_texto_1;
	
	
	private String valor_texto_2;
	

	private String valor_texto_3;
	
	
	private String valor_texto_4;
	

	private String estado_generico;
	

	private Date fecha_registro_generico;
	


	public Long getId_generico_tabla() {
		return id_generico_tabla;
	}

	public void setId_generico_tabla(Long id_generico_tabla) {
		this.id_generico_tabla = id_generico_tabla;
	}

	public String getCod_tabla() {
		return cod_tabla;
	}

	public void setCod_tabla(String cod_tabla) {
		this.cod_tabla = cod_tabla;
	}

	public String getCod_fila() {
		return cod_fila;
	}

	public void setCod_fila(String cod_fila) {
		this.cod_fila = cod_fila;
	}

	public String getDesc_corta() {
		return desc_corta;
	}

	public void setDesc_corta(String desc_corta) {
		this.desc_corta = desc_corta;
	}
	
	public String getDesc_larga() {
		return desc_larga;
	}

	public void setDesc_larga(String desc_larga) {
		this.desc_larga = desc_larga;
	}

	public String getValor_texto_1() {
		return valor_texto_1;
	}

	public void setValor_texto_1(String valor_texto_1) {
		this.valor_texto_1 = valor_texto_1;
	}

	public String getValor_texto_2() {
		return valor_texto_2;
	}

	public void setValor_texto_2(String valor_texto_2) {
		this.valor_texto_2 = valor_texto_2;
	}

	public String getValor_texto_3() {
		return valor_texto_3;
	}

	public void setValor_texto_3(String valor_texto_3) {
		this.valor_texto_3 = valor_texto_3;
	}

	public String getValor_texto_4() {
		return valor_texto_4;
	}

	public void setValor_texto_4(String valor_texto_4) {
		this.valor_texto_4 = valor_texto_4;
	}

	public String getEstado_generico() {
		return estado_generico;
	}

	public void setEstado_generico(String estado_generico) {
		this.estado_generico = estado_generico;
	}

	public Date getFecha_registro_generico() {
		return fecha_registro_generico;
	}

	public void setFecha_registro_generico(Date fecha_registro_generico) {
		this.fecha_registro_generico = fecha_registro_generico;
	}
	
}
