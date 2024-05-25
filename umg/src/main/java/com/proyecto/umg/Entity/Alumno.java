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
@Table(name = "alumno")
public class Alumno implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4680309637220623048L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idalumno")
	private Integer idalumno;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "carnet")
	private String carnet;
	
	@OneToMany(mappedBy = "alumnoIdalumno")
	private List<Asignacion> asignacionList;

	public Integer getIdalumno() {
		return idalumno;
	}

	public void setIdalumno(Integer idalumno) {
		this.idalumno = idalumno;
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

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}
	
	public List<Asignacion> getAsignacionList() {
		return asignacionList;
	}

	public void setAsignacionList(List<Asignacion> asignacionList) {
		this.asignacionList = asignacionList;
	}
	

}
