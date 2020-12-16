package br.com.mvc.projeto.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.mvc.projeto.model.Voo;



class VooRepositoryTest {

	@Autowired
	private Pageable paginacao;
	
	@Autowired
	private VooRepository vooRepository;
	
	@Test
	public void buscarVoosPorMatricula() {
		String matricula = "123456";
		Page<Voo> voos = vooRepository.findByAviaoMatricula(matricula, paginacao);
		Assert.assertNotNull(voos);
		
	}
	@Test
	public void naoEncontrarVooPormatricula() {
		String matricula = "1256";
		Page<Voo> voos = vooRepository.findByAviaoMatricula(matricula, paginacao);
		Assert.assertNull(voos);
		
	}

}
