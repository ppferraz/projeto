package br.com.mvc.projeto.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mvc.projeto.model.Piloto;

public interface PilotoRepository extends JpaRepository<Piloto, Long> {

	Piloto findByNome(String nome);
	Page<Piloto> findByNome(String nome, Pageable paginacao);

}
