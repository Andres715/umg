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

import com.proyecto.umg.Entity.Alumno;
import com.proyecto.umg.Entity.Asignacion;
import com.proyecto.umg.Repository.AlumnoRepository;
import com.proyecto.umg.Repository.AsignacionRepository;

@RestController
@RequestMapping("/alumno")
@CrossOrigin
public class AlumnoService {

	@Autowired
	AlumnoRepository alumnoRepository;
	@Autowired
	AsignacionRepository asignacionRepository;
	
	//Buscar Alumnos
	@GetMapping(path = "/buscar")
	public List<Alumno> buscarAlumno(){
		return alumnoRepository.findAll();
	}
	
	//Agregar Alumnos
	@PostMapping(path = "/guardar")
	public Alumno guardar(@RequestBody Alumno alumno) {
		List<Asignacion> asignaciones = alumno.getAsignacionList();
		alumno.setAsignacionList(null);
		alumnoRepository.save(alumno);
		
		for(Asignacion asig: asignaciones) {
			asig.setAlumnoIdalumno(alumno.getIdalumno());
		}
		asignacionRepository.saveAll(asignaciones);
		alumno.setAsignacionList(asignaciones);
		return alumno;
	}
	
	//Eliminiar Alumnos
	@DeleteMapping(path = "/eliminar/{idalumno}")
	public void eliminar(@PathVariable ("idalumno") Integer idalumno) {
		Optional<Alumno> alumno = alumnoRepository.findById(idalumno);
		if(alumno.isPresent()) {
			asignacionRepository.deleteAll(alumno.get().getAsignacionList());
			alumnoRepository.delete(alumno.get());
			
		}
	}
	
	//Busqueda De Alumnos Por password y Carnet
	@GetMapping(path = "/buscar/por/{password}/{carnet}")
	public List<Alumno> buscarPorCarnetYPassword(@PathVariable String password, @PathVariable String carnet){
		return alumnoRepository.findByPasswordAndCarnet(password, carnet);
	}

	//Busqueda De Alumnos Por Id
	@GetMapping(path = "/buscar/por/{idalumno}")
	public Optional<Alumno> buscarPorId(@PathVariable Integer idalumno){
		Optional<Alumno> alumno = alumnoRepository.findById(idalumno);
		return alumno;
	}
	
	//Login Alumno
	@PostMapping(path = "/login")
	public List<Alumno> login(@RequestBody Alumno alumno){
		return alumnoRepository.findByPasswordAndCarnet(alumno.getPassword(), alumno.getCarnet());
	}
}
