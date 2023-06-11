package com.expressJobs.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "menus")
public class Menus {
    @Id
    @Column(name = "id_menu")
    private Long id_menu;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "url")
    private String url;

    @Column(name = "icon")
    private String icon;
    
    @Column(name = "provided")
    private String provided;

    @Column(name = "active")
    private boolean active;

    @Column(name = "class_active")
    private String class_active;

    @Transient
    private List<SubMenus> submenus = new ArrayList<>();
    
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "menu")
//    private List<SubMenus> subitem = new ArrayList<>();
    
    public Menus() {
	}

	public Menus(Long id_menu, String title, String description, String url, String icon, String provided,
			boolean active, String class_active, List<SubMenus> submenus) {
		super();
		this.id_menu = id_menu;
		this.title = title;
		this.description = description;
		this.url = url;
		this.icon = icon;
		this.provided = provided;
		this.active = active;
		this.class_active = class_active;
		this.submenus = submenus;
	}

	public Long getId_menu() {
		return id_menu;
	}

	public void setId_menu(Long id_menu) {
		this.id_menu = id_menu;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getProvided() {
		return provided;
	}

	public void setProvided(String provided) {
		this.provided = provided;
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

	public List<SubMenus> getSubitem() {
		return submenus;
	}

	public void setSubitem(List<SubMenus> submenus) {
		this.submenus = submenus;
	}
    
}