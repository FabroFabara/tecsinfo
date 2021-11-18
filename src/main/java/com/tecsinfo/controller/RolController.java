package com.tecsinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecsinfo.entities.Rol;
import com.tecsinfo.service.RolService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
public class RolController {

	@Autowired
	private RolService rolService;

	@ApiOperation(value = "Metodo que retorna el listado de los roles", notes = "Metodo que retorna el listado de los roles")
	@GetMapping("/rol/listarRoles")
	public ResponseEntity<List<Rol>> listarUsuarios() throws Exception {
		return new ResponseEntity<>(rolService.listarRoles(), HttpStatus.OK);
	}

}
