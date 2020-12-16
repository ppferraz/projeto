package br.com.mvc.projeto.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.mvc.projeto.model.Piloto;
import br.com.mvc.projeto.repository.PilotoRepository;

public class AtualizacaoPilotoForm {
	
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String email;
	
	@NotNull @NotEmpty 
	private String comentario;
	
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Piloto atualizar(Long id, PilotoRepository pilotoRepository) {
		Piloto piloto =pilotoRepository.getOne(id);
		
		piloto.setNome(this.nome);
		piloto.setEmail(this.email);
		piloto.setComentario(this.comentario);
		
		return piloto;
	}
	
}
