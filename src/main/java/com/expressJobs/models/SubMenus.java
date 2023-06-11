package com.expressJobs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "submenus")
public class SubMenus {

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(name = "id_submenu")
    private Long id_submenu;

    @Column(name = "description")
    private String description;

    @Column(name = "url")
    private String url;

    @Column(name = "active")
    private boolean active;

    @Column(name = "class_active")
    private String class_active;
    
    @Column(name = "id_menu")
    private Long id_menu;
    
    public SubMenus() {
	}
    
	public SubMenus(Long id, Long id_submenu, String description, String url, boolean active, String class_active,
			Long id_menu) {
		super();
		this.id = id;
		this.id_submenu = id_submenu;
		this.description = description;
		this.url = url;
		this.active = active;
		this.class_active = class_active;
		this.id_menu = id_menu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_submenu() {
		return id_submenu;
	}

	public void setId_submenu(Long id_submenu) {
		this.id_submenu = id_submenu;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getClass_active() {
		return class_active;
	}

	public void setClass_active(String class_active) {
		this.class_active = class_active;
	}

	public Long getId_menu() {
		return id_menu;
	}

	public void setId_menu(Long id_menu) {
		this.id_menu = id_menu;
	}
}