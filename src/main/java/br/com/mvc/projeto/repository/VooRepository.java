package br.com.mvc.projeto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mvc.projeto.model.Voo;

public interface VooRepository extends JpaRepository<Voo, Long> {

	Page<Voo> findByAviaoMatricula(String matriculaAviao, Pageable paginacao);

}
