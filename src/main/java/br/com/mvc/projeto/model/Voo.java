package br.com.mvc.projeto.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Voo {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private String terminal;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	private LocalDate dataVoo = LocalDate.now();
	private LocalTime horarioChegada = LocalTime.now();
	private LocalTime horarioPartida = LocalTime.now();
	@Enumerated(EnumType.STRING)
	private StatusVoo status = StatusVoo.CADASTRADO;
	@ManyToOne
	private Usuario autor;
	@ManyToOne
	private Piloto piloto;
	@ManyToOne
	private Cidade cidadeOrigem;
	@ManyToOne
	private Cidade cidadeDestino;
	@ManyToOne
	private Aviao aviao;
	//@OneToMany(mappedBy = "topico")
	//private List<Resposta> respostas = new ArrayList<>();
	
	public Voo() {
	}
	
	public Voo(String descricao, String terminal, Aviao aviao) {
		this.descricao = descricao;
		this.terminal = terminal;
		this.aviao = aviao;
	}

	public Voo(String descricao, String terminal, LocalDate dataVoo, LocalTime horarioChegada, LocalTime horarioPartida,
			Usuario autor, Piloto piloto, Cidade cidadeOrigem, Cidade cidadeDestino, Aviao aviao) {
		super();
		this.descricao = descricao;
		this.terminal = terminal;
		this.dataVoo = dataVoo;
		this.horarioChegada = horarioChegada;
		this.horarioPartida = horarioPartida;
		this.autor = autor;
		this.piloto = piloto;
		this.cidadeOrigem = cidadeOrigem;
		this.cidadeDestino = cidadeDestino;
		this.aviao = aviao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public LocalDate getDataVoo() {
		return dataVoo;
	}

	public void setDataVoo(LocalDate dataVoo) {
		this.dataVoo = dataVoo;
	}

	public LocalTime getHorarioChegada() {
		return horarioChegada;
	}

	public void setHorarioChegada(LocalTime horarioChegada) {
		this.horarioChegada = horarioChegada;
	}

	public LocalTime getHorarioPartida() {
		return horarioPartida;
	}

	public void setHorarioPartida(LocalTime horarioPartida) {
		this.horarioPartida = horarioPartida;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public Cidade getCidadeOrigem() {
		return cidadeOrigem;
	}

	public void setCidadeOrigem(Cidade cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}

	public Cidade getCidadeDestino() {
		return cidadeDestino;
	}

	public void setCidadeDestino(Cidade cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}

	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voo other = (Voo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public StatusVoo getStatus() {
		return status;
	}

	public void setStatus(StatusVoo status) {
		this.status = status;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Aviao getAviao() {
		return aviao;
	}

	public void setCurso(Aviao aviao) {
		this.aviao = aviao;
	}

	

}
