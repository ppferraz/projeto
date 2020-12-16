package br.com.mvc.projeto.controller.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.mvc.projeto.model.StatusVoo;
import br.com.mvc.projeto.model.Voo;

public class DetalhesDoVooDto {

	private Long id;
	private String descricao;
	private String terminal;
	private LocalDateTime dataCriacao;
	private String nomeAutor;
	private StatusVoo status;
	private String nomePiloto;
	private String matriculaAviao;
	private String cidadeOrigem;
	private String cidadeDestino;
	private String horarioChegada;
	private String horarioPartida;
	private String dataVoo;
	//private List<RespostaDto> respostas;
	
	public DetalhesDoVooDto(Voo voo) {
		this.id = voo.getId();
		this.descricao = voo.getDescricao();
		this.terminal = voo.getTerminal();
		this.dataCriacao = voo.getDataCriacao();
		this.nomeAutor = voo.getAutor().getNome();
		this.status = voo.getStatus();
		this.nomePiloto = voo.getPiloto().getNome();
		this.matriculaAviao = voo.getAviao().getMatricula();
		this.cidadeOrigem = voo.getCidadeOrigem().getNome();
		this.cidadeDestino = voo.getCidadeDestino().getNome();
		this.horarioChegada = voo.getHorarioChegada().toString();
		this.horarioPartida = voo.getHorarioPartida().toString();
		this.dataVoo = voo.getDataVoo().toString();
		//this.respostas = new ArrayList<>();
		//this.respostas.addAll(topico.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList()));
	}

	public String getDescricao() {
		return descricao;
	}

	public String getTerminal() {
		return terminal;
	}

	public StatusVoo getStatus() {
		return status;
	}

	public String getNomePiloto() {
		return nomePiloto;
	}

	public String getMatriculaAviao() {
		return matriculaAviao;
	}

	public String getCidadeOrigem() {
		return cidadeOrigem;
	}

	public String getCidadeDestino() {
		return cidadeDestino;
	}

	public String getHorarioChegada() {
		return horarioChegada;
	}

	public String getHorarioPartida() {
		return horarioPartida;
	}

	public String getDataVoo() {
		return dataVoo;
	}

	public Long getId() {
		return id;
	}
	

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

		
}
