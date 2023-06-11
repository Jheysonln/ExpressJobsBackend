package com.expressJobs.request;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.Nullable;

public class UsuarioRequest {

	private Long id_usuario;
	private String username;
	private String ape_usuario;
	private String email;
	private String password;
	private String password_confirm;
	@Nullable
	private int id_prefijo_telefono;
	@Nullable
	private String telefono_usuario = "";
	@Nullable
	private int id_tipodocumento;
	@Nullable
	private String num_documento = "";
	@Nullable
	private int id_Depa;
	@Nullable
	private int id_provincia;
	@Nullable
	private int id_dist;
	@Nullable
	private String direc_usuario = "";
	@Nullable
	private Long id_rol;
	@Nullable
	private int id_especialidad;
	
	private Date fecha_registro;

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getApe_usuario() {
		return ape_usuario;
	}

	public void setApe_usuario(String ape_usuario) {
		this.ape_usuario = ape_usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword_confirm() {
		return password_confirm;
	}

	public void setPassword_confirm(String password_confirm) {
		this.password_confirm = password_confirm;
	}

	public int getId_prefijo_telefono() {
		return id_prefijo_telefono;
	}

	public void setId_prefijo_telefono(int id_prefijo_telefono) {
		this.id_prefijo_telefono = id_prefijo_telefono;
	}

	public String getTelefono_usuario() {
		return telefono_usuario;
	}

	public void setTelefono_usuario(String telefono_usuario) {
		this.telefono_usuario = telefono_usuario;
	}

	public int getId_tipodocumento() {
		return id_tipodocumento;
	}

	public void setId_tipodocumento(int id_tipodocumento) {
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

	public Long getId_rol() {
		return id_rol;
	}

	public void setId_rol(Long id_rol) {
		this.id_rol = id_rol;
	}

	public int getId_especialidad() {
		return id_especialidad;
	}

	public void setId_especialidad(int id_especialidad) {
		this.id_especialidad = id_especialidad;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	
}
