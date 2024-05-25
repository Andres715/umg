package com.proyecto.umg.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.umg.Entity.Curso;

@Repository("cursoRepository")
public interface CursoRepository extends JpaRepository<Curso, Serializable>{
	
	public List<Curso> findByProfesorIdprofesorOrNombre(Integer profesorIdprofesor, String nombre);
	
	public List<Curso> findByNombreAndProfesorIdprofesor(String nombre, Integer profesorIdprofesor);
	
	public List<Curso> findByProfesorIdprofesorEquals(Integer profesorIdprofesor);

}
