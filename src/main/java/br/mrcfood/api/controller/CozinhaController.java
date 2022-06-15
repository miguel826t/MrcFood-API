package br.mrcfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import br.mrcfood.api.model.CozinhasXml;
import br.mrcfood.domain.entity.Cozinha;
import br.mrcfood.infrastructure.repository.CozinhaRepository;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	// Define o tipo que este metodo retorna (produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cozinha> listar(){
		return cozinhaRepository.buscarAll();
	}
	
	// Se a solicitacao for um XML ele retornara neste metodo
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhasXml listarXml(){
		return new CozinhasXml(cozinhaRepository.buscarAll());
	}
	
	@GetMapping(value = "/{cozinhaId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long id) {
		Cozinha cozinha = cozinhaRepository.buscarPorId(id);
		if(cozinha == null) {
			//return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(cozinha);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void adicionar(@RequestBody Cozinha cozinha) {
		cozinhaRepository.adicionar(cozinha);
	}
	
}
