package com.proyecto.umg.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.umg.Entity.Asignacion;

@Repository("asignacionRepository")
public interface AsignacionRepository extends JpaRepository<Asignacion, Serializable>{
	
	public List<Asignacion> findByAlumnoIdalumnoOrNota(Integer alumnoIdalumno, Double nota);

	public List<Asignacion> findByAlumnoIdalumnoEquals(Integer alumnoIdalumno);
	
	public List<Asignacion> findByCursoIdcursoEquals(Integer cursoIdcurso);


}
