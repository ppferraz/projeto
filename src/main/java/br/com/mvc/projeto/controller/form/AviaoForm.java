package br.com.mvc.projeto.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.mvc.projeto.model.Aviao;




public class AviaoForm {
	@NotNull @NotEmpty
	private String matricula;
	
	@NotNull @NotEmpty
	private String modelo;
	
	@NotNull @NotEmpty
	private String companhia;
	
	
	

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}




	public void setModelo(String modelo) {
		this.modelo = modelo;
	}




	public void setCompanhia(String companhia) {
		this.companhia = companhia;
	}




	public Aviao converter() {
		return new Aviao(matricula, modelo, companhia );
	}

}
