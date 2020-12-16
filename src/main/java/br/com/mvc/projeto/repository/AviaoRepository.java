package br.com.mvc.projeto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mvc.projeto.model.Aviao;

public interface AviaoRepository extends JpaRepository<Aviao, Long> {

	Aviao findByMatricula (String matricula);
	Page<Aviao> findByMatricula(String matricula, Pageable paginacao);
}
