package com.proyecto.umg.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.umg.Entity.Administrador;

@Repository("administradorRepository")
public interface AdministradorRepository extends JpaRepository<Administrador, Serializable> {

}
