package com.expressJobs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long 	idUsuario;
    private String 	nombreUsuario;
    private String	apellidoUsuario;
    private String  correoUsuario;
    private String  contraseniaUsuario;
    private String	prefijoUsuario;
    private String  telefonoUsuario;
	private String  idDocumentoUsuario;
    private String  documentoUsuario;
    private Integer idDepartamento;
    private Integer idProvincia;
    private Integer idDistrito;
    private String  direccion;
    private Integer  idRol;
    private Integer idEspecialidad;
    
    
    public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getApellidoUsuario() {
		return apellidoUsuario;
	}
	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}
	public String getCorreoUsuario() {
		return correoUsuario;
	}
	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}
	public String getContraseniaUsuario() {
		return contraseniaUsuario;
	}
	public void setContraseniaUsuario(String contraseniaUsuario) {
		this.contraseniaUsuario = contraseniaUsuario;
	}
	public String getPrefijoUsuario() {
		return prefijoUsuario;
	}
	public void setPrefijoUsuario(String prefijoUsuario) {
		this.prefijoUsuario = prefijoUsuario;
	}
	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}
	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}
	public String getIdDocumentoUsuario() {
		return idDocumentoUsuario;
	}
	public void setIdDocumentoUsuario(String idDocumentoUsuario) {
		this.idDocumentoUsuario = idDocumentoUsuario;
	}
	public String getDocumentoUsuario() {
		return documentoUsuario;
	}
	public void setDocumentoUsuario(String documentoUsuario) {
		this.documentoUsuario = documentoUsuario;
	}
	public Integer getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public Integer getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(Integer idProvincia) {
		this.idProvincia = idProvincia;
	}
	public Integer getIdDistrito() {
		return idDistrito;
	}
	public void setIdDistrito(Integer idDistrito) {
		this.idDistrito = idDistrito;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	public Integer getidEspecialidad() {
		return idEspecialidad;
	}
	public void setidEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}


}
