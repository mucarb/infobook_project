package com.murilo.infobook.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murilo.infobook.entities.Usuario;
import com.murilo.infobook.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario searchById(Integer id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);		
		return obj.orElse(null);
	}
	
}
