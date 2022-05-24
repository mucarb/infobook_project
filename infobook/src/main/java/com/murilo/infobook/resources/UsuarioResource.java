package com.murilo.infobook.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.murilo.infobook.dtos.UsuarioDTO;
import com.murilo.infobook.dtos.UsuarioNewDTO;
import com.murilo.infobook.entities.Usuario;
import com.murilo.infobook.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> searchById(@PathVariable Integer id) {
		Usuario obj = usuarioService.searchById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioNewDTO objNewDto) {
		Usuario obj = usuarioService.fromDto(objNewDto);
		obj = usuarioService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioDTO objDto, @PathVariable Integer id) {
		Usuario obj = usuarioService.fromDto(objDto);
		obj.setId(id);
		usuarioService.update(obj);
		return ResponseEntity.noContent().build();
	}

}
