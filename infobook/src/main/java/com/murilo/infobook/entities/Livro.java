package com.murilo.infobook.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private Integer paginas;
	private Double valorDeMulta;

	@ManyToOne
	@JoinColumn(name = "editora_id")
	private Editora editora;

	@ManyToOne
	@JoinColumn(name = "genero_id")
	private Genero genero;

	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;

	@ManyToOne
	@JoinColumn(name = "colecao_id")
	private Colecao colecao;

	public Livro() {
	}

	public Livro(Integer id, String titulo, Integer paginas, Double valorDeMulta, Editora editora, Genero genero,
			Autor autor) {
		this.id = id;
		this.titulo = titulo;
		this.paginas = paginas;
		this.valorDeMulta = valorDeMulta;
		this.editora = editora;
		this.genero = genero;
		this.autor = autor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	public Double getValorDeMulta() {
		return valorDeMulta;
	}

	public void setValorDeMulta(Double valorDeMulta) {
		this.valorDeMulta = valorDeMulta;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Colecao getColecao() {
		return colecao;
	}

	public void setColecao(Colecao colecao) {
		this.colecao = colecao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}

}
