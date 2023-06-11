package com.expressJobs.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "generico")
public class Generico {

	@Id
	@Column(name = "id_generico_tabla")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_generico_tabla;

	@Column(name = "cod_tabla")
	private String cod_tabla;
	
	@Column(name = "cod_fila")
	private String cod_fila;
	
	@Column(name = "desc_corta")
	private String desc_corta;
	
	@Column(name = "desc_larga")
	private String desc_larga;
	
	@Column(name = "valor_texto_1")
	private String valor_texto_1;
	
	@Column(name = "valor_texto_2")
	private String valor_texto_2;
	
	@Column(name = "valor_texto_3")
	private String valor_texto_3;
	
	@Column(name = "valor_texto_4")
	private String valor_texto_4;
	
	@Column(name = "estado_generico")
	private String estado_generico;
	
	@Column(name = "fecha_registro_generico")
	private Date fecha_registro_generico;

	public Generico() {
		
	}
	
	public Generico(Long id_generico_tabla, String cod_tabla, String cod_fila,String desc_corta, String desc_larga, String valor_texto_1,
			String valor_texto_2, String valor_texto_3, String valor_texto_4, String estado_generico,
			Date fecha_registro_generico) {
		super();
		this.id_generico_tabla = id_generico_tabla;
		this.cod_tabla = cod_tabla;
		this.cod_fila = cod_fila;
		this.desc_corta = desc_corta;
		this.desc_larga = desc_larga;
		this.valor_texto_1 = valor_texto_1;
		this.valor_texto_2 = valor_texto_2;
		this.valor_texto_3 = valor_texto_3;
		this.valor_texto_4 = valor_texto_4;
		this.estado_generico = estado_generico;
		this.fecha_registro_generico = fecha_registro_generico;
	}

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
