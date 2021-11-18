package com.tecsinfo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tecsinfo.entities.Usuario;
import com.tecsinfo.exception.ModeloNotFoundException;
import com.tecsinfo.service.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@ApiOperation(value = "Metodo que retorna el listado de usuarios", notes = "Metodo que retorna el listado de usaurios")
	@GetMapping("/usuarios/listarUsuarios")
	public ResponseEntity<List<Usuario>> listarUsuarios() throws Exception {
		return new ResponseEntity<>(usuarioService.listarUsuarios(), HttpStatus.OK);
	}

	@ApiOperation(value = "Metodo que retorna usuario por Username", notes = "Metodo que retorna usuario por Username")
	@GetMapping("/usuarios/{username}")
	public ResponseEntity<Usuario> listarPorId(@PathVariable("username") String username) throws Exception {
		Usuario user = usuarioService.recuperarUsuario(username);

		if (user == null) {
			throw new ModeloNotFoundException("No se ha encontrado usuario " + username);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@ApiOperation(value = "Metodo que permite registrar usuarios", notes = "Metodo que permite registrar usuarios")
	@PostMapping
	public ResponseEntity<Usuario> registrar(@Valid @RequestBody Usuario user) throws Exception {
		usuarioService.registrarUsuario(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/usuarios/{username}")
				.buildAndExpand(user.getUsername()).toUri();
		return ResponseEntity.created(location).build();
	}
}
