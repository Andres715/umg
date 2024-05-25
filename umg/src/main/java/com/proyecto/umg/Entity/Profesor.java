package com.proyecto.umg.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -611770681126812487L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idprofesor")
	private Integer idprofesor;
	
	@Column(name = "user")
	private String user;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "password")
	private String password;
	
	@Column(name ="telefono")
	private String telefono;

	@OneToMany(mappedBy = "profesorIdprofesor")
	private List<Curso> cursoList;
	
	public Integer getIdprofesor() {
		return idprofesor;
	}

	public void setIdprofesor(Integer idprofesor) {
		this.idprofesor = idprofesor;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Curso> getCursoList() {
		return cursoList;
	}

	public void setCursoList(List<Curso> cursoList) {
		this.cursoList = cursoList;
	}
	
	

}
