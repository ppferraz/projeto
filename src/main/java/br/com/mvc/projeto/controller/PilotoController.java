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

import br.com.mvc.projeto.controller.dto.PilotoDto;
import br.com.mvc.projeto.controller.form.AtualizacaoPilotoForm;
import br.com.mvc.projeto.controller.form.PilotoForm;
import br.com.mvc.projeto.model.Piloto;
import br.com.mvc.projeto.repository.PilotoRepository;

@RestController
@RequestMapping("/pilotos")
public class PilotoController {
	@Autowired
	private PilotoRepository pilotoRepository;
	
	@GetMapping
	@Cacheable(value = "listaDePilotos")
	public Page<PilotoDto> lista(@RequestParam(required = false) String nomePiloto, 
			@PageableDefault(sort = "nome", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		
		if (nomePiloto == null) {
			Page<Piloto> pilotos = pilotoRepository.findAll(paginacao);
			return PilotoDto.converter(pilotos);
		} else {
			Page<Piloto> pilotos = pilotoRepository.findByNome(nomePiloto, paginacao);
			return PilotoDto.converter(pilotos);
		}
	}
	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDePilotos", allEntries = true)
	public ResponseEntity<PilotoDto> cadastrar(@RequestBody @Valid PilotoForm form, UriComponentsBuilder uriBuilder) {
		Piloto piloto = form.converter();
		pilotoRepository.save(piloto);
		
		URI uri = uriBuilder.path("/piloto/{id}").buildAndExpand(piloto.getId()).toUri();
		return ResponseEntity.created(uri).body(new PilotoDto(piloto));
	}
	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDePilotos", allEntries = true)
	public ResponseEntity<PilotoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoPilotoForm form) {
		Optional<Piloto> optional = pilotoRepository.findById(id);
		if (optional.isPresent()) {
			Piloto piloto = form.atualizar(id, pilotoRepository);
			return ResponseEntity.ok(new PilotoDto(piloto));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDePilotos", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Piloto> optional = pilotoRepository.findById(id);
		if (optional.isPresent()) {
			pilotoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
