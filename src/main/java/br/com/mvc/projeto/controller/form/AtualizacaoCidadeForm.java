package br.com.mvc.projeto.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.mvc.projeto.model.Cidade;
import br.com.mvc.projeto.repository.CidadeRepository;

public class AtualizacaoCidadeForm {
	
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty @Length(min = 2)
	private String estado;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cidade atualizar(Long id, CidadeRepository cidadeRepository) {
		Cidade cidade = cidadeRepository.getOne(id);
		
		cidade.setNome(this.nome);
		cidade.setEstado(this.estado);
		
		return cidade;
	}
	
}
