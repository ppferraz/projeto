package br.com.mvc.projeto.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import br.com.mvc.projeto.model.Piloto;



public class PilotoForm {
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty 
	private String email;
	
	@NotNull @NotEmpty 
	private String comentario;
	
	

	public void setNome(String nome) {
		this.nome = nome;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setComentario(String comentario) {
		this.comentario = comentario;
	}



	public Piloto converter() {
		return new Piloto(nome, email, comentario);
	}

}
