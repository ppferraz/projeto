package br.com.mvc.projeto.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.mvc.projeto.controller.dto.DetalhesDoVooDto;
import br.com.mvc.projeto.controller.dto.VooDto;
import br.com.mvc.projeto.controller.form.VooForm;
import br.com.mvc.projeto.model.Voo;
import br.com.mvc.projeto.repository.AviaoRepository;
import br.com.mvc.projeto.repository.CidadeRepository;
import br.com.mvc.projeto.repository.PilotoRepository;
import br.com.mvc.projeto.repository.UsuarioRepository;
import br.com.mvc.projeto.repository.VooRepository;



@RestController
@RequestMapping("/voos")
public class VoosController {
	
	@Autowired
	private VooRepository vooRepository;
	
	@Autowired
	private AviaoRepository aviaoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private PilotoRepository pilotoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public Page<VooDto> lista(@RequestParam(required = false) String matriculaAviao, 
			@PageableDefault(sort = "dataCriacao", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		
		if (matriculaAviao == null) {
			Page<Voo> voos = vooRepository.findAll(paginacao);
			return VooDto.converter(voos);
		} else {
			Page<Voo> voos = vooRepository.findByAviaoMatricula(matriculaAviao, paginacao);
			return VooDto.converter(voos);
		}
	}
	
	@PostMapping
	@Transactional
	
	public ResponseEntity<VooDto> cadastrar(@RequestBody @Valid VooForm form, UriComponentsBuilder uriBuilder) {
		Voo voo = form.converter(aviaoRepository, pilotoRepository,cidadeRepository,usuarioRepository);
		vooRepository.save(voo);
		
		URI uri = uriBuilder.path("/voos/{id}").buildAndExpand(voo.getId()).toUri();
		return ResponseEntity.created(uri).body(new VooDto(voo));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoVooDto> detalhar(@PathVariable Long id) {
		Optional<Voo> voo = vooRepository.findById(id);
		if (voo.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoVooDto(voo.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
		
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Voo> optional = vooRepository.findById(id);
		if (optional.isPresent()) {
			vooRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}