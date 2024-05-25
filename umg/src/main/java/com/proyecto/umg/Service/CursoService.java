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
import com.proyecto.umg.Entity.Curso;
import com.proyecto.umg.Repository.AsignacionRepository;
import com.proyecto.umg.Repository.CursoRepository;
import com.proyecto.umg.Repository.ProfesorRepository;

@RestController
@CrossOrigin
@RequestMapping("/curso")
public class CursoService {

	@Autowired
	CursoRepository cursoRepository;
	@Autowired
	AsignacionRepository asignacionRepository;
	@Autowired
	ProfesorRepository profesorRepository;
	
	//Buscar Cursos
	@GetMapping(path = "/buscar")
	public List<Curso> buscarCurso(){
		return cursoRepository.findAll();
	}
	
	//Agregar Cursos
	@PostMapping(path = "/guardar")
	public Curso guardar(@RequestBody Curso curso) {
		List<Asignacion> asignaciones = curso.getAsignacionList();
		curso.setAsignacionList(null);
		cursoRepository.save(curso);
		
		for(Asignacion asig: asignaciones) {
			asig.setCursoIdcurso(curso.getIdcurso());
		}
		asignacionRepository.saveAll(asignaciones);
		curso.setAsignacionList(asignaciones);
		return curso;
	}
	
	//Eliminar Cursos
	@DeleteMapping(path = "/eliminar/{idcurso}")
	public void eliminar(@PathVariable ("idcurso") Integer idcurso) {
		Optional<Curso> curso = cursoRepository.findById(idcurso);
		if(curso.isPresent()) {
			asignacionRepository.deleteAll(curso.get().getAsignacionList());
			cursoRepository.delete(curso.get());
		}
	}
	
	//Busqueda De Cursos Por Id
	@GetMapping(path = "/buscar/por/{idcurso}")
	public Optional<Curso> buscarPorId(@PathVariable Integer idcurso){
		Optional<Curso> curso = cursoRepository.findById(idcurso);
			return curso;
	}
	
	//Busqueda De Cursos Por Id Profesor o Nombre de Curso
	@GetMapping(path = "/buscar/por/{profesorIdprofesor}/or/{nombre}")
	public List<Curso> buscarPorProfesorIdprofesorOrNombre(@PathVariable Integer profesorIdprofesor, @PathVariable String nombre){
		return cursoRepository.findByProfesorIdprofesorOrNombre(profesorIdprofesor, nombre);
	}
	
	//Busqueda De Cursos Por Nombre de Curso y Id Profesor
	@GetMapping(path = "/buscar/por/{nombre}/{profesorIdprofesor}")
	public List<Curso> buscarPorNombreYProfesorIdprofesor(@PathVariable String nombre, @PathVariable Integer profesorIdprofesor){
		return cursoRepository.findByNombreAndProfesorIdprofesor(nombre, profesorIdprofesor);
	}

	//Busqueda De Curso Por Id Profesor
	@GetMapping(path = "/buscar/por-profesor/{profesorIdprofesor}")
	public List<Curso> buscarPorProfesorIdprofesorEquals(@PathVariable Integer profesorIdprofesor){
		return cursoRepository.findByProfesorIdprofesorEquals(profesorIdprofesor);
	}
	
}
