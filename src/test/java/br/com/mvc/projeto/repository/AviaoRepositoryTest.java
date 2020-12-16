package br.com.mvc.projeto.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;


import br.com.mvc.projeto.model.Aviao;


@DataJpaTest 
//@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AviaoRepositoryTest {
	@Autowired
	private AviaoRepository aviaoRepository;
	@Test
	public void buscarAviaoporMatricula() {
		String matricula = "123456";
		Aviao aviao = aviaoRepository.findByMatricula(matricula);
		Assert.assertNotNull(aviao);
		Assert.assertEquals(matricula, aviao.getMatricula());
	}
	@Test
	public void naoEncontrarAviaoporMatricula() {
		String matricula = "1256";
		Aviao aviao = aviaoRepository.findByMatricula(matricula);
		Assert.assertNull(aviao);
		
	}

}
