package com.expressJobs.request;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UsuarioRequest {


	private Long id_usuario;

	
	private String nom_usuario;

	private String ape_usuario;

	private String correo_usuario;

	private String password_usuario;

	private String id_prefijo_telefono;

	private String telefono_usuario;

	private String id_tipodocumento;

	private String num_documento;

	private int id_Depa;

	private int id_provincia;

	private int id_dist;

	private String direc_usuario;

	private int id_rol;

	private int id_especialidad;
	

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNom_usuario() {
		return nom_usuario;
	}

	public void setNom_usuario(String nom_usuario) {
		this.nom_usuario = nom_usuario;
	}

	public String getApe_usuario() {
		return ape_usuario;
	}

	public void setApe_usuario(String ape_usuario) {
		this.ape_usuario = ape_usuario;
	}

	public String getCorreo_usuario() {
		return correo_usuario;
	}

	public void setCorreo_usuario(String correo_usuario) {
		this.correo_usuario = correo_usuario;
	}

	public String getPassword_usuario() {
		return password_usuario;
	}

	public void setPassword_usuario(String password_usuario) {
		this.password_usuario = password_usuario;
	}

	public String getId_prefijo_telefono() {
		return id_prefijo_telefono;
	}

	public void setId_prefijo_telefono(String id_prefijo_telefono) {
		this.id_prefijo_telefono = id_prefijo_telefono;
	}

	public String getTelefono_usuario() {
		return telefono_usuario;
	}

	public void setTelefono_usuario(String telefono_usuario) {
		this.telefono_usuario = telefono_usuario;
	}

	public String getId_tipodocumento() {
		return id_tipodocumento;
	}

	public void setId_tipodocumento(String id_tipodocumento) {
		this.id_tipodocumento = id_tipodocumento;
	}

	public String getNum_documento() {
		return num_documento;
	}

	public void setNum_documento(String num_documento) {
		this.num_documento = num_documento;
	}

	public int getId_Depa() {
		return id_Depa;
	}

	public void setId_Depa(int id_Depa) {
		this.id_Depa = id_Depa;
	}

	public int getId_provincia() {
		return id_provincia;
	}

	public void setId_provincia(int id_provincia) {
		this.id_provincia = id_provincia;
	}

	public int getId_dist() {
		return id_dist;
	}

	public void setId_dist(int id_dist) {
		this.id_dist = id_dist;
	}

	public String getDirec_usuario() {
		return direc_usuario;
	}

	public void setDirec_usuario(String direc_usuario) {
		this.direc_usuario = direc_usuario;
	}

	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}

	public int getId_especialidad() {
		return id_especialidad;
	}

	public void setId_especialidad(int id_especialidad) {
		this.id_especialidad = id_especialidad;
	}
	
	
}
