package br.com.mvc.projeto.controller.dto;


import org.springframework.data.domain.Page;

import br.com.mvc.projeto.model.Piloto;

public class PilotoDto {
	private Long id;
	private String nome;
	private String email;
	private String comentario;
	
	public PilotoDto(Piloto piloto) {
		this.id = piloto.getId();
		this.nome = piloto.getNome();
		this.email = piloto.getEmail();
		this.comentario = piloto.getComentario();
	}	

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}
	public static Page<PilotoDto> converter(Page<Piloto> pilotos) {
		return pilotos.map(PilotoDto::new);
	}

	public String getComentario() {
		return comentario;
	}

	
	

}
