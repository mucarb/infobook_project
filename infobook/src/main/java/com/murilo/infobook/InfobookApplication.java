package com.murilo.infobook;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.murilo.infobook.entities.Cidade;
import com.murilo.infobook.entities.Endereco;
import com.murilo.infobook.entities.Estado;
import com.murilo.infobook.entities.Usuario;
import com.murilo.infobook.repositories.CidadeRepository;
import com.murilo.infobook.repositories.EnderecoRepository;
import com.murilo.infobook.repositories.EstadoRepository;
import com.murilo.infobook.repositories.UsuarioRepository;

@SpringBootApplication
public class InfobookApplication implements CommandLineRunner {

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(InfobookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Estado est1 = new Estado(null, "Minas Gerais");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);

		est1.getCidades().addAll(Arrays.asList(c1));

		estadoRepository.saveAll(Arrays.asList(est1));
		cidadeRepository.saveAll(Arrays.asList(c1));

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", c1);

		Usuario u1 = new Usuario(null, "Ana Clara", "10749021659", "anaclara@gmail.com", "12345678", e1);
		u1.getTelefones().addAll(Arrays.asList("1899617013", "1832811212"));

		e1.setUsuario(u1);
		
		enderecoRepository.saveAll(Arrays.asList(e1));
		usuarioRepository.saveAll(Arrays.asList(u1));
	}

}
