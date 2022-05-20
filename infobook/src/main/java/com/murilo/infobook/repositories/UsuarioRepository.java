package com.murilo.infobook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.murilo.infobook.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Transactional(readOnly = true)
	public Usuario findByCpf(String cpf);

	@Transactional(readOnly = true)
	public Usuario findByEmail(String email);

}
