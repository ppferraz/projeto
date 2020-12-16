package br.com.mvc.projeto.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mvc.projeto.controller.dto.AviaoDto;
import br.com.mvc.projeto.controller.form.AtualizacaoAviaoForm;
import br.com.mvc.projeto.controller.form.AviaoForm;
import br.com.mvc.projeto.model.Aviao;
import br.com.mvc.projeto.repository.AviaoRepository;


@RestController
@RequestMapping("/avioes")
public class AviaoController {
	@Autowired
	private AviaoRepository aviaoRepository;
	
	@GetMapping
	@Cacheable(value = "listaDeAvioes")
	public Page<AviaoDto> lista(@RequestParam(required = false) String matricula, 
			@PageableDefault(sort = "matricula", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		
		if (matricula == null) {
			Page<Aviao> avioes = aviaoRepository.findAll(paginacao);
			return AviaoDto.converter(avioes);
		} else {
			Page<Aviao> avioes = aviaoRepository.findByMatricula(matricula, paginacao);
			return AviaoDto.converter(avioes);
		}
	}
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeAvioes", allEntries = true)
	public ResponseEntity<AviaoDto> cadastrar(@RequestBody @Valid AviaoForm form, UriComponentsBuilder uriBuilder) {
		Aviao aviao = form.converter();
		aviaoRepository.save(aviao);
		
		URI uri = uriBuilder.path("/aviao/{id}").buildAndExpand(aviao.getId()).toUri();
		return ResponseEntity.created(uri).body(new AviaoDto(aviao));
	}
	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeAvioes", allEntries = true)
	public ResponseEntity<AviaoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoAviaoForm form) {
		Optional<Aviao> optional = aviaoRepository.findById(id);
		if (optional.isPresent()) {
			Aviao aviao = form.atualizar(id, aviaoRepository);
			return ResponseEntity.ok(new AviaoDto(aviao));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeAvioes", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Aviao> optional = aviaoRepository.findById(id);
		if (optional.isPresent()) {
			aviaoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
