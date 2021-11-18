package com.tecsinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsinfo.entities.Usuario;
import com.tecsinfo.exception.ModeloNotFoundException;
import com.tecsinfo.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepo;

	public Usuario recuperarUsuario(String username) {
		Usuario user = usuarioRepo.findOneByUsername(username);

		if (user == null) {
			throw new ModeloNotFoundException("No existe usuario registrado");
		} else {
			return user;
		}

	}

	public List<Usuario> listarUsuarios() {
		List<Usuario> usuarios = usuarioRepo.findAll();

		if (usuarios.isEmpty()) {
			throw new ModeloNotFoundException("No existen usuarios registrados");
		} else {
			return usuarios;
		}

	}

	public void registrarUsuario(Usuario usuario) {
		usuarioRepo.save(usuario);
	}
}
