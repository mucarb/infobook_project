package com.murilo.infobook.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.murilo.infobook.dtos.UsuarioDTO;
import com.murilo.infobook.dtos.UsuarioNewDTO;
import com.murilo.infobook.entities.Cidade;
import com.murilo.infobook.entities.Endereco;
import com.murilo.infobook.entities.Usuario;
import com.murilo.infobook.repositories.CidadeRepository;
import com.murilo.infobook.repositories.EnderecoRepository;
import com.murilo.infobook.repositories.UsuarioRepository;
import com.murilo.infobook.services.exceptions.DataIntegrityViolationException;
import com.murilo.infobook.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private BCryptPasswordEncoder pe;

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

	public Usuario update(Usuario obj) {
		Usuario oldObj = usuarioRepository.getById(obj.getId());
		Usuario objAux = usuarioRepository.findByEmail(obj.getEmail());
		
		if (uniqueEmailValidation(obj.getEmail()) && objAux.getId() != obj.getId()) {
			throw new DataIntegrityViolationException("Email já existente na base de dados!");
		}

		updateData(oldObj, obj);
		return usuarioRepository.save(oldObj);
	}

	public Usuario fromDto(UsuarioNewDTO objNewDto) {
		validateUniqueData(objNewDto);

		Cidade cidade = cidadeRepository.getById(objNewDto.getCidadeId());

		Endereco endereco = new Endereco(null, objNewDto.getLogradouro(), objNewDto.getNumero(),
				objNewDto.getComplemento(), objNewDto.getBairro(), objNewDto.getCep(), cidade);

		Usuario usuario = new Usuario(null, objNewDto.getNome(), objNewDto.getCpf(), objNewDto.getEmail(),
				pe.encode(objNewDto.getSenha()), endereco);

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

	public Usuario fromDto(UsuarioDTO objDto) {
		Cidade cidade = cidadeRepository.getById(objDto.getCidadeId());

		Endereco endereco = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(),
				objDto.getBairro(), objDto.getCep(), cidade);

		Usuario usuario = new Usuario(null, objDto.getNome(), objDto.getEmail(), endereco);

		endereco.setUsuario(usuario);

		usuario.getTelefones().add(objDto.getTelefone1());

		if (objDto.getTelefone2() != null) {
			usuario.getTelefones().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3() != null) {
			usuario.getTelefones().add(objDto.getTelefone2());
		}

		return usuario;
	}

	private void updateData(Usuario oldObj, Usuario obj) {
		oldObj.setNome(obj.getNome());
		oldObj.setEmail(obj.getEmail());
		oldObj.setEndereco(obj.getEndereco());
		oldObj.getEndereco().setId(obj.getId());
		oldObj.setTelefones(obj.getTelefones());
	}

	private void validateUniqueData(UsuarioNewDTO objNewDto) {
		if (uniqueCpfValidation(objNewDto.getCpf())) {
			throw new DataIntegrityViolationException("CPF já existente na base de dados!");
		}

		if (uniqueEmailValidation(objNewDto.getEmail())) {
			throw new DataIntegrityViolationException("Email já existente na base de dados!");
		}
	}

	private boolean uniqueCpfValidation(String cpf) {
		return usuarioRepository.findByCpf(cpf) != null;
	}

	private boolean uniqueEmailValidation(String email) {
		return usuarioRepository.findByEmail(email) != null;
	}

}
