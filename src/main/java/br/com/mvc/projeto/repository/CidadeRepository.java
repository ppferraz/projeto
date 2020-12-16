package br.com.mvc.projeto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mvc.projeto.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	Cidade findByNome(String nome);
	Page<Cidade> findByNome(String nome, Pageable paginacao);
}
