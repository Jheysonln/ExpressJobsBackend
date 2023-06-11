package com.expressJobs.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @Column(name = "id_rol")
    private Long id_rol;

    @Column(name = "des_rol")
    private String des_rol;

    @Column(name = "estado_rol")
    private boolean estado_rol;

	public Long getId_rol() {
		return id_rol;
	}

	public void setId_rol(Long id_rol) {
		this.id_rol = id_rol;
	}

	public String getDes_rol() {
		return des_rol;
	}

	public void setDes_rol(String des_rol) {
		this.des_rol = des_rol;
	}

	public boolean isEstado_rol() {
		return estado_rol;
	}

	public void setEstado_rol(boolean estado_rol) {
		this.estado_rol = estado_rol;
	}

}
