package br.com.mvc.projeto.controller.dto;


import org.springframework.data.domain.Page;

import br.com.mvc.projeto.model.Aviao;


public class AviaoDto {
	private Long id;
	private String matricula;
	private String modelo;
	private String companhia;
	
	public AviaoDto(Aviao aviao) {
		this.id = aviao.getId();
		this.matricula = aviao.getMatricula();
		this.modelo = aviao.getModelo();
		this.companhia = aviao.getCompanhia();
		
	}

	public Long getId() {
		return id;
	}

	
	public String getMatricula() {
		return matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public String getCompanhia() {
		return companhia;
	}



	public static Page<AviaoDto> converter(Page<Aviao> avioes) {
		return avioes.map(AviaoDto::new);
	}

	
	

}
