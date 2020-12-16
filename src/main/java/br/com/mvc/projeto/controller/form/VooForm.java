package br.com.mvc.projeto.controller.form;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.mvc.projeto.model.Aviao;
import br.com.mvc.projeto.model.Cidade;
import br.com.mvc.projeto.model.Piloto;
import br.com.mvc.projeto.model.Usuario;
import br.com.mvc.projeto.model.Voo;
import br.com.mvc.projeto.repository.AviaoRepository;
import br.com.mvc.projeto.repository.CidadeRepository;
import br.com.mvc.projeto.repository.PilotoRepository;
import br.com.mvc.projeto.repository.UsuarioRepository;


public class VooForm {

	@NotNull @NotEmpty @Length(min = 10)
	private String descricao;
	
	@NotNull @NotEmpty @Length(min = 5)
	private String terminal;
	
	private LocalDate dataVoo;
	
	@NotNull @NotEmpty  
	private String horarioChegada;
	
	@NotNull @NotEmpty 
	private String horarioPartida;
	
	@NotNull @NotEmpty
	private String nomePiloto;
	
	@NotNull @NotEmpty
	private String cidadeOrigem;
	
	@NotNull @NotEmpty
	private String cidadeDestino;
	
	@NotNull @NotEmpty
	private String matriculaAviao;

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}


	public void setDataVoo(String dataVoo) {
		int dia,mes,ano;
		if(dataVoo.indexOf("//")<0) {
			dia=Integer.parseInt(dataVoo.substring(0,2));
			mes=Integer.parseInt(dataVoo.substring(3,5));
			ano=Integer.parseInt(dataVoo.substring(6,10));
		}else {
			dia=Integer.parseInt(dataVoo.substring(0,1));
			mes=Integer.parseInt(dataVoo.substring(2,3));
			ano=Integer.parseInt(dataVoo.substring(4,8));
		}
		System.out.println(dataVoo);
		System.out.println(dia +" "+mes+" "+ano);
		this.dataVoo = LocalDate.of(ano,mes,dia);
	}


	public void setHorarioChegada(String horarioChegada) {
		this.horarioChegada = horarioChegada;
	}


	public void setHorarioPartida(String horarioPartida) {
		this.horarioPartida = horarioPartida;
	}


	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}


	public void setCidadeOrigem(String cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}


	public void setCidadeDestino(String cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}


	public void setMatriculaAviao(String matriculaAviao) {
		this.matriculaAviao = matriculaAviao;
	}


	public Voo converter(AviaoRepository aviaoRepository, PilotoRepository pilotoRepository, CidadeRepository cidadeRepository, UsuarioRepository usuarioRepository) {
		Aviao aviao = aviaoRepository.findByMatricula(matriculaAviao);
		Usuario autor = usuarioRepository.findByNome("admin");
		Piloto piloto = pilotoRepository.findByNome(nomePiloto);
		Cidade cidOrigem = cidadeRepository.findByNome(cidadeOrigem);
		Cidade cidDestino = cidadeRepository.findByNome(cidadeDestino);
		LocalTime horChegada = LocalTime.parse(horarioChegada);
		LocalTime horPartida = LocalTime.parse(horarioPartida);
		
		return new Voo(descricao, terminal, dataVoo, horChegada, horPartida, autor,piloto,cidOrigem,cidDestino,aviao);
	}

}
