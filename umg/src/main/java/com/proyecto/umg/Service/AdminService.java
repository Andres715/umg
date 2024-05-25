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

import com.proyecto.umg.Entity.Admin;
import com.proyecto.umg.Repository.AdminRepository;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	//Buscar Usuarios Tipo Administrador
	@GetMapping(path = "/buscar")
	public List<Admin> buscar(){
		return adminRepository.findAll();
	}
	
	//Agregar Usuarios Tipo Administrador
	@PostMapping(path = "/guardar")
	public Admin guardar(@RequestBody Admin admin) {
		return adminRepository.save(admin);
	}
	
	//Eliminar Usuarios Tipo Administrador
	@DeleteMapping(path = "/eliminar/{idadmin}")
	public void eliminar(@PathVariable ("idadmin") Integer idadmin) {
		Optional<Admin> admin = adminRepository.findById(idadmin);
		if(admin.isPresent()) {
			adminRepository.delete(admin.get());
		}
	}
	
	//Busqueda De Usuarios Tipo Administrador Por User y Password
	@GetMapping(path = "/buscar/por/{user}/{password}")
	public List<Admin> buscarPorUserYPassword(@PathVariable String user, @PathVariable String password){
		return adminRepository.findByUserAndPassword(user, password);
	}
	

	//Login Admin
	@PostMapping(path = "/login")
	public List<Admin> login(@RequestBody Admin admin){
		return adminRepository.findByUserAndPassword(admin.getUser(), admin.getPassword());
	}
	
	//Actualizar Admin
	@GetMapping(path = "/update/{idadmin}")
	public Admin update(@RequestBody Admin admin) {
		return adminRepository.save(admin);
	}

	

}
