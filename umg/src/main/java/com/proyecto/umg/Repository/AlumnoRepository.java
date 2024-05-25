package com.proyecto.umg.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.umg.Entity.Alumno;

@Repository("alumnoRepository")
public interface AlumnoRepository extends JpaRepository<Alumno, Serializable>{
	
	public List<Alumno> findByPasswordAndCarnet(String password, String carnet);
}
