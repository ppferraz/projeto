package br.com.mvc.projeto.controller.dto;


import org.springframework.data.domain.Page;
import br.com.mvc.projeto.model.Usuario;

public class UsuarioDto {
	private Long id;
	private String nome;
	private String email;
	
	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
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
	public static Page<UsuarioDto> converter(Page<Usuario> usuarios) {
		return usuarios.map(UsuarioDto::new);
	}

	
	

}
