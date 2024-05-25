package com.proyecto.umg.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.umg.Entity.Profesor;

@Repository("profesorRepository")
public interface ProfesorRepository extends JpaRepository<Profesor, Serializable>{
	public List<Profesor> findByUserAndPassword(String user, String password);
	public List<Profesor> findByUserEquals(String user);
}
