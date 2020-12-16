package br.com.mvc.projeto.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.mvc.projeto.model.Usuario;
import br.com.mvc.projeto.repository.UsuarioRepository;

public class AtualizacaoUsuarioForm {
	
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String email;
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.getOne(id);
		
		usuario.setNome(this.nome);
		usuario.setEmail(this.email);
		
		return usuario;
	}
	
}
