package com.murilo.infobook.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murilo.infobook.dtos.UsuarioNewDTO;
import com.murilo.infobook.entities.Cidade;
import com.murilo.infobook.entities.Endereco;
import com.murilo.infobook.entities.Usuario;
import com.murilo.infobook.repositories.CidadeRepository;
import com.murilo.infobook.repositories.EnderecoRepository;
import com.murilo.infobook.repositories.UsuarioRepository;
import com.murilo.infobook.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public Usuario searchById(Integer id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Usuário: objeto não foi encontrado, ID: " + id + ", Tipo: " + Usuario.class.getName()));
	}

	public Usuario insert(Usuario obj) {
		obj.setId(null);
		obj = usuarioRepository.save(obj);
		enderecoRepository.save(obj.getEndereco());
		return obj;
	}

	public Usuario fromDto(UsuarioNewDTO objNewDto) {
		Cidade cidade = cidadeRepository.getById(objNewDto.getCidadeId());

		Endereco endereco = new Endereco(null, objNewDto.getLogradouro(), objNewDto.getNumero(),
				objNewDto.getComplemento(), objNewDto.getBairro(), objNewDto.getCep(), cidade);

		Usuario usuario = new Usuario(null, objNewDto.getNome(), objNewDto.getCpf(), objNewDto.getEmail(),
				objNewDto.getSenha(), endereco);

		endereco.setUsuario(usuario);

		usuario.getTelefones().add(objNewDto.getTelefone1());

		if (objNewDto.getTelefone2() != null) {
			usuario.getTelefones().add(objNewDto.getTelefone2());
		}
		if (objNewDto.getTelefone3() != null) {
			usuario.getTelefones().add(objNewDto.getTelefone2());
		}

		return usuario;
	}

}
