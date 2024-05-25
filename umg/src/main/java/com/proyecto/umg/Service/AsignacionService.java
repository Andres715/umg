package com.proyecto.umg.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.umg.Entity.Asignacion;
import com.proyecto.umg.Repository.AlumnoRepository;
import com.proyecto.umg.Repository.AsignacionRepository;
import com.proyecto.umg.Repository.CursoRepository;

@RestController
@CrossOrigin
@RequestMapping("/asignacion")
public class AsignacionService {

	@Autowired
	AlumnoRepository alumnoRepository;
	
	@Autowired
	CursoRepository cursoRepository;
	
	@Autowired
	AsignacionRepository asignacionRepository;
	
	//Buscar Asignacion
	@GetMapping(path = "/buscar")
	public List<Asignacion> buscarAsignacion(){
		return asignacionRepository.findAll();
	}
	
	//Agregar Asignacion
	@PostMapping(path = "/guardar")
	public Asignacion guardar(@RequestBody Asignacion asignacion) {
		return asignacionRepository.save(asignacion);
	}

	//Eliminar Asignacion
	@DeleteMapping(path = "/eliminar/{idasignacion}")
	public void eliminar(@PathVariable ("idasignacion") Integer idasignacion) {
		Optional<Asignacion> asignacion = asignacionRepository.findById(idasignacion);
		if(asignacion.isPresent()) {
			asignacionRepository.delete(asignacion.get());
		}
	}
	
	//Busqueda De Asignacion Por Id Alumno o Nota
	@GetMapping(path = "/buscar/por/{alumnoIdalumno}/or/{nota}")
	public List<Asignacion> buscarPorAlumnoIdalumnoOrNota(@PathVariable Integer alumnoIdalumno, @PathVariable Double nota){
		return asignacionRepository.findByAlumnoIdalumnoOrNota(alumnoIdalumno, nota);
	}

	//Busqueda De Asignacion Por Id Alumno
	@GetMapping(path = "/buscar/por/{alumnoIdalumno}")
	public List<Asignacion> buscarPorAlumnoIdalumnoEquals(@PathVariable Integer alumnoIdalumno){
		return asignacionRepository.findByAlumnoIdalumnoEquals(alumnoIdalumno);
	}
	
	//Busqueda De Asignacion Por Id Curso
	@GetMapping(path = "/buscar/por-curso/{cursoIdcurso}")
	public List<Asignacion> buscarPorCursoIdcursoEquals(@PathVariable Integer cursoIdcurso){
		return asignacionRepository.findByCursoIdcursoEquals(cursoIdcurso);
	}
}
