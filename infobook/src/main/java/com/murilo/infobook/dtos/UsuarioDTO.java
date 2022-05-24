package com.murilo.infobook.dtos;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.murilo.infobook.entities.Usuario;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento do campo NOME obrigatório")
	@Length(min = 3, max = 120, message = "Nome deve ser entre 3 e 120 caracteres")
	private String nome;

	@NotEmpty(message = "Preenchimento do campo EMAIL obrigatório")
	@Email(message = "Email inválido")
	private String email;

	@NotEmpty(message = "Preenchimento do campo LOGRADOURO obrigatório")
	private String logradouro;

	@NotEmpty(message = "Preenchimento do campo NÚMERO obrigatório")
	private String numero;
	private String complemento;

	@NotEmpty(message = "Preenchimento do campo BAIRRO obrigatório")
	private String bairro;

	@NotEmpty(message = "Preenchimento do campo CEP obrigatório")
	private String cep;

	@NotNull(message = "Campo CIDADE não informado")
	private Integer cidadeId;

	@NotEmpty(message = "Preenchimento do campo TELEFONE obrigatório")
	private String telefone1;
	private String telefone2;
	private String telefone3;

	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario obj) {
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.logradouro = obj.getEndereco().getLogradouro();
		this.numero = obj.getEndereco().getNumero();
		this.complemento = obj.getEndereco().getComplemento();
		this.bairro = obj.getEndereco().getBairro();
		this.cep = obj.getEndereco().getCep();
		this.cidadeId = obj.getEndereco().getCidade().getId();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

}
