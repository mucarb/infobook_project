package com.murilo.infobook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InfobookApplication {

	/*
	 * @Autowired private EstadoRepository estadoRepository;
	 * 
	 * @Autowired private CidadeRepository cidadeRepository;
	 * 
	 * @Autowired private EnderecoRepository enderecoRepository;
	 * 
	 * @Autowired private UsuarioRepository usuarioRepository;
	 * 
	 * @Autowired private EditoraRepository editoraRepository;
	 * 
	 * @Autowired private GeneroRepository generoRepository;
	 * 
	 * @Autowired private AutorRepository autorRepository;
	 * 
	 * @Autowired private LivroRepository livroRepository;
	 * 
	 * @Autowired private ColecaoRepository colecaoRepository;
	 */

	public static void main(String[] args) {
		SpringApplication.run(InfobookApplication.class, args);
	}

	/*
	 * @Override public void run(String... args) throws Exception {
	 * 
	 * Estado est1 = new Estado(null, "Minas Gerais");
	 * 
	 * Cidade cid1 = new Cidade(null, "Uberlândia", est1);
	 * 
	 * est1.getCidades().addAll(Arrays.asList(cid1));
	 * 
	 * estadoRepository.saveAll(Arrays.asList(est1));
	 * cidadeRepository.saveAll(Arrays.asList(cid1));
	 * 
	 * Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim",
	 * "38220834", cid1);
	 * 
	 * Usuario u1 = new Usuario(null, "Ana Clara", "10749021659",
	 * "anaclara@gmail.com", "12345678", e1);
	 * u1.getTelefones().addAll(Arrays.asList("1899617013", "1832811212"));
	 * 
	 * e1.setUsuario(u1);
	 * 
	 * enderecoRepository.saveAll(Arrays.asList(e1));
	 * usuarioRepository.saveAll(Arrays.asList(u1));
	 * 
	 * Editora ed1 = new Editora(null, "Sextante"); Editora ed2 = new Editora(null,
	 * "Bookman");
	 * 
	 * Genero g1 = new Genero(null, "Informática"); Genero g2 = new Genero(null,
	 * "Fantasia");
	 * 
	 * Autor aut1 = new Autor(null, "J.R.R. Tolkien"); Autor aut2 = new Autor(null,
	 * "Cay Horstmann");
	 * 
	 * editoraRepository.saveAll(Arrays.asList(ed1, ed2));
	 * generoRepository.saveAll(Arrays.asList(g1, g2));
	 * autorRepository.saveAll(Arrays.asList(aut1, aut2));
	 * 
	 * Livro l1 = new Livro(null, "Core Java", 320, 2.00, ed2, g1, aut2); Livro l2 =
	 * new Livro(null, "Senhor dos Anéis", 1100, 3.00, ed1, g2, aut1); Livro l3 =
	 * new Livro(null, "O Hobbit", 310, 2.00, ed1, g2, aut1);
	 * 
	 * Colecao c1 = new Colecao(null, "Java Oficial", l1);
	 * 
	 * l1.setColecao(c1);
	 * 
	 * ed1.getLivros().addAll(Arrays.asList(l2, l3));
	 * ed2.getLivros().addAll(Arrays.asList(l1));
	 * 
	 * g1.getLivros().addAll(Arrays.asList(l1));
	 * g2.getLivros().addAll(Arrays.asList(l2, l3));
	 * 
	 * aut1.getLivros().addAll(Arrays.asList(l2, l3));
	 * aut2.getLivros().addAll(Arrays.asList(l1));
	 * 
	 * colecaoRepository.saveAll(Arrays.asList(c1));
	 * livroRepository.saveAll(Arrays.asList(l1, l2, l3)); }
	 */

}
