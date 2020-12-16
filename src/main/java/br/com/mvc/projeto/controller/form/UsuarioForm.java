package br.com.mvc.projeto.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.mvc.projeto.model.Usuario;



public class UsuarioForm {
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String email;
	
	@NotNull @NotEmpty @Length(min = 6)
	private String senha;
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Usuario converter() {
		return new Usuario(nome, email,senha);
	}

	

}
