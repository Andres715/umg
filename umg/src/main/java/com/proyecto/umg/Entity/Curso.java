package com.proyecto.umg.Entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "curso")
public class Curso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idcurso")
	private Integer idcurso;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "seccion")
	private char seccion;
	
	@Column(name = "dia")
	private String dia;
	
	@Column(name = "inicio_fecha")
	private Date inicio = new Date();
	
	@Column(name = "fin_fecha")
	private Date fin = new Date();
	
	@Column(name = "inicio_hora")
	private String inicioHora;
	
	@Column(name = "fin_hora")
	private String finHora;
	
	@Column(name = "profesor_idprofesor")
	private Integer profesorIdprofesor;
	
	@Column(name = "profesor_nombre")
	private String profesorNombre;
	
	@OneToMany(mappedBy = "cursoIdcurso")
	private List<Asignacion> asignacionList;

	public Integer getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(Integer idcurso) {
		this.idcurso = idcurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getSeccion() {
		return seccion;
	}
	
	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public void setSeccion(char seccion) {
		this.seccion = seccion;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public String getInicioHora() {
		return inicioHora;
	}

	public void setInicioHora(String inicioHora) {
		this.inicioHora = inicioHora;
	}

	public String getFinHora() {
		return finHora;
	}

	public void setFinHora(String finHora) {
		this.finHora = finHora;
	}

	public Integer getProfesorIdprofesor() {
		return profesorIdprofesor;
	}

	public void setProfesorIdprofesor(Integer profesorIdprofesor) {
		this.profesorIdprofesor = profesorIdprofesor;
	}

	public String getProfesorNombre() {
		return profesorNombre;
	}

	public void setProfesorNombre(String profesorNombre) {
		this.profesorNombre = profesorNombre;
	}

	public List<Asignacion> getAsignacionList() {
		return asignacionList;
	}

	public void setAsignacionList(List<Asignacion> asignacionList) {
		this.asignacionList = asignacionList;
	}

	
	
}
