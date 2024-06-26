package com.proyecto.umg.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.umg.Entity.Admin;

@Repository("adminRepository")
public interface AdminRepository extends JpaRepository<Admin, Serializable>{

	public List<Admin> findByUserAndPassword(String user, String password);
}
