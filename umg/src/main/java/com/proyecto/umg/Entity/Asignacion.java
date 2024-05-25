package com.proyecto.umg.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asignacion")
public class Asignacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8596650298658665656L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idasignacion")
	private Integer idasignacion;
	
	@Column(name = "nota")
	private Double nota;
	
	@Column(name = "alumno_idalumno")
	private Integer alumnoIdalumno;

	@Column(name = "alumno_nombre")
	private String alumnoNombre;
	
	@Column(name = "alumno_apellido")
	private String alumnoApellido;
	
	@Column(name = "alumno_carnet")
	private String alumnoCarnet;
	
	@Column(name = "curso_idcurso")
	private Integer cursoIdcurso;
	
	@Column(name = "curso_nombre")
	private String cursoNombre;
	
	@Column(name = "curso_seccion")
	private String cursoSeccion;
	
	@Column(name = "curso_inicio_fecha")
	private Date cursoInicioFecha = new Date();
	
	@Column(name = "curso_fin_fecha")
	private Date cursoFinFecha = new Date();
	
	@Column(name = "curso_inicio_hora")
	private String cursoInicioHora;
	
	@Column(name = "curso_fin_hora")
	private String cursoFinHora;
	
	@Column(name = "curso_dia")
	private String cursoDia;
	
	@Column(name = "curso_profesor_nombre")
	private String cursoProfesorNombre;

	public Integer getIdasignacion() {
		return idasignacion;
	}

	public void setIdasignacion(Integer idasignacion) {
		this.idasignacion = idasignacion;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Integer getAlumnoIdalumno() {
		return alumnoIdalumno;
	}

	public void setAlumnoIdalumno(Integer alumnoIdalumno) {
		this.alumnoIdalumno = alumnoIdalumno;
	}

	public String getAlumnoNombre() {
		return alumnoNombre;
	}

	public void setAlumnoNombre(String alumnoNombre) {
		this.alumnoNombre = alumnoNombre;
	}

	public String getAlumnoApellido() {
		return alumnoApellido;
	}

	public void setAlumnoApellido(String alumnoApellido) {
		this.alumnoApellido = alumnoApellido;
	}

	public String getAlumnoCarnet() {
		return alumnoCarnet;
	}

	public void setAlumnoCarnet(String alumnoCarnet) {
		this.alumnoCarnet = alumnoCarnet;
	}

	public Integer getCursoIdcurso() {
		return cursoIdcurso;
	}

	public void setCursoIdcurso(Integer cursoIdcurso) {
		this.cursoIdcurso = cursoIdcurso;
	}

	public String getCursoNombre() {
		return cursoNombre;
	}

	public void setCursoNombre(String cursoNombre) {
		this.cursoNombre = cursoNombre;
	}

	public String getCursoSeccion() {
		return cursoSeccion;
	}

	public void setCursoSeccion(String cursoSeccion) {
		this.cursoSeccion = cursoSeccion;
	}

	public Date getCursoInicioFecha() {
		return cursoInicioFecha;
	}

	public void setCursoInicioFecha(Date cursoInicioFecha) {
		this.cursoInicioFecha = cursoInicioFecha;
	}

	public Date getCursoFinFecha() {
		return cursoFinFecha;
	}

	public void setCursoFinFecha(Date cursoFinFecha) {
		this.cursoFinFecha = cursoFinFecha;
	}

	public String getCursoInicioHora() {
		return cursoInicioHora;
	}

	public void setCursoInicioHora(String cursoInicioHora) {
		this.cursoInicioHora = cursoInicioHora;
	}

	public String getCursoFinHora() {
		return cursoFinHora;
	}

	public void setCursoFinHora(String cursoFinHora) {
		this.cursoFinHora = cursoFinHora;
	}

	public String getCursoDia() {
		return cursoDia;
	}

	public void setCursoDia(String cursoDia) {
		this.cursoDia = cursoDia;
	}

	public String getCursoProfesorNombre() {
		return cursoProfesorNombre;
	}

	public void setCursoProfesorNombre(String cursoProfesorNombre) {
		this.cursoProfesorNombre = cursoProfesorNombre;
	}
	
}
