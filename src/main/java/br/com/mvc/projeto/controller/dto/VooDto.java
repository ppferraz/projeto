package br.com.mvc.projeto.controller.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.mvc.projeto.model.Voo;

public class VooDto {

	private Long id;
	private String descricao;
	private String terminal;
	private LocalDateTime dataCriacao;
	
	public VooDto(Voo voo) {
		this.id = voo.getId();
		this.descricao = voo.getDescricao();
		this.terminal = voo.getTerminal();
		this.dataCriacao = voo.getDataCriacao();
	}

	public Long getId() {
		return id;
	}



	public String getDescricao() {
		return descricao;
	}

	public String getTerminal() {
		return terminal;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public static Page<VooDto> converter(Page<Voo> voos) {
		return voos.map(VooDto::new);
	}

}
