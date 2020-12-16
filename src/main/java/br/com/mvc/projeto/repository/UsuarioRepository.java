package br.com.mvc.projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mvc.projeto.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByEmail(String email);
	Usuario findByNome(String nome);
	Page<Usuario> findByNome(String nome, Pageable paginacao);
	

}
