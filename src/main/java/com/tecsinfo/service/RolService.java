package com.tecsinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsinfo.entities.Rol;
import com.tecsinfo.exception.ModeloNotFoundException;
import com.tecsinfo.repositories.RolRepository;

@Service
public class RolService {

	@Autowired
	private RolRepository rolRepo;

	public List<Rol> listarRoles() {
		List<Rol> roles = rolRepo.findAll();

		if (roles.isEmpty()) {
			throw new ModeloNotFoundException("No existen roles registrados");
		} else {
			return roles;
		}

	}

}
