package com.proyecto.umg.Entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7391955667165950490L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idadmin")
	private Integer idadmin;
	
	@Column(name = "user")
	private String user;
	
	@Column(name = "password")
	private String password;

	public Integer getIdadmin() {
		return idadmin;
	}

	public void setIdadmin(Integer idadmin) {
		this.idadmin = idadmin;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
