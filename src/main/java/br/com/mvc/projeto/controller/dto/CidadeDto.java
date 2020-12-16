package br.com.mvc.projeto.controller.dto;


import org.springframework.data.domain.Page;


import br.com.mvc.projeto.model.Cidade;

public class CidadeDto {
	private Long id;
	private String nome;
	private String estado;
	
	public CidadeDto(Cidade cidade) {
		this.id = cidade.getId();
		this.nome = cidade.getNome();
		this.estado = cidade.getEstado();
		
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEstado() {
		return estado;
	}
	public static Page<CidadeDto> converter(Page<Cidade> cidades) {
		return cidades.map(CidadeDto::new);
	}

	
	

}
