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

import com.proyecto.umg.Entity.Curso;
import com.proyecto.umg.Entity.Profesor;
import com.proyecto.umg.Repository.CursoRepository;
import com.proyecto.umg.Repository.ProfesorRepository;

@RestController
@RequestMapping("/profesor")
@CrossOrigin
public class ProfesorService {

	@Autowired
	ProfesorRepository profesorRepository;
	@Autowired
	CursoRepository cursoRepository;
	
	//Buscar Usuario Tipo Profesor
	@GetMapping(path = "/buscar")
	public List<Profesor> buscar(){
		return profesorRepository.findAll();
	}
	
	//Agregar Usuario Tipo Profesor
	@PostMapping(path = "/guardar")
	public Profesor guardar(@RequestBody Profesor profesor) {
		List<Curso> cursos = profesor.getCursoList();
		profesor.setCursoList(null);
		profesorRepository.save(profesor);
		
		for(Curso curs: cursos) {
			curs.setProfesorIdprofesor(profesor.getIdprofesor());
		}
		cursoRepository.saveAll(cursos);
		profesor.setCursoList(cursos);
		return profesor;
	}
	
	//Eliminar Usuario Tipo Profesor
	@DeleteMapping(path = "/eliminar/{idprofesor}")
	public void eliminar (@PathVariable ("idprofesor") Integer idprofesor) {
		Optional<Profesor> profesor = profesorRepository.findById(idprofesor);
		if(profesor.isPresent()) {
			profesorRepository.delete(profesor.get());
		}
	}
	
	//Busqueda De Profesores Por User y Password
	@GetMapping(path = "/buscar/por/{user}/{password}")
	public List<Profesor> buscarPorUserYPassword(@PathVariable String user, @PathVariable String password){
		return profesorRepository.findByUserAndPassword(user, password);
	}
	
	//Busqueda De Profesores Por Id
		@GetMapping(path = "/buscar/por/{idprofesor}")
	public Optional<Profesor> buscarPorId(@PathVariable Integer idprofesor){
		Optional<Profesor> profesor = profesorRepository.findById(idprofesor);
			return profesor;
	}
		
	//Busqueda de Profesores Por User
	@GetMapping(path = "/buscar/por-user/{user}")
	public List<Profesor> buscarPorUserEquals(@PathVariable String user){
		return profesorRepository.findByUserEquals(user);
	}

	//Login Profesor
	@PostMapping(path = "/login")
	public List<Profesor> login(@RequestBody Profesor profesor){
		return profesorRepository.findByUserAndPassword(profesor.getUser(), profesor.getPassword());
	}
}
