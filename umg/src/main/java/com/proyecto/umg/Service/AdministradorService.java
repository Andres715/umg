package com.proyecto.umg.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.umg.Entity.Administrador;
import com.proyecto.umg.Repository.AdministradorRepository;

@RestController
@RequestMapping("/administrador")
@CrossOrigin
public class AdministradorService {
	@Autowired
	AdministradorRepository administradorRepository;
	
	@GetMapping(path = "/buscar")
	public List<Administrador> buscar(){
		return administradorRepository.findAll();
	}
}
