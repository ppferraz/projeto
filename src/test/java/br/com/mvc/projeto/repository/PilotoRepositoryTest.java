package br.com.mvc.projeto.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.mvc.projeto.model.Piloto;

class PilotoRepositoryTest {

	@Autowired
	private Pageable paginacao;
	
	@Autowired
	private PilotoRepository pilotoRepository;
	
	@Test
	public void buscarPilotosPorNome() {
		String nome = "Cleber";
		Page<Piloto> pilotos = pilotoRepository.findByNome(nome, paginacao);
		Assert.assertNotNull(pilotos);
		
	}
	@Test
	public void naoEncontrarPilotosPorNome() {
		String nome = "João";
		Page<Piloto> pilotos = pilotoRepository.findByNome(nome, paginacao);
		Assert.assertNull(pilotos);
		
	}

}
