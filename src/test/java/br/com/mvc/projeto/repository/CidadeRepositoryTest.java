package br.com.mvc.projeto.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.mvc.projeto.model.Cidade;

public class CidadeRepositoryTest {
	
	
	@Autowired
	private Pageable paginacao;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Test
	public void buscarCidadesPorNome() {
		String cidade = "Paraiso";
		Page<Cidade> cidades = cidadeRepository.findByNome(cidade, paginacao );
		Assert.assertNotNull(cidades);
		
	}
	@Test
	public void naoEncontrarCidadesPorNome() {
		String cidade = "São Paulo";
		Page<Cidade> cidades = cidadeRepository.findByNome(cidade, paginacao );
		Assert.assertNull(cidades);
		
	}
}
