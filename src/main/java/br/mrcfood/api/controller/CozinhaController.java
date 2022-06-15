package br.mrcfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping(value = "/{cozinhaId}",produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long id) {
		Cozinha cozinha = cozinhaRepository.buscarPorId(id);
		
		/* ======* Formas de retornar Status *====== */
		//return ResponseEntity.status(HttpStatus.OK).body(cozinha);
		//return ResponseEntity.ok(cozinha);  //Retonar o OK com conteudo
		//return ResponseEntity.ok().build(); //Retornaria OK mas sem conteudo
		
		/* ======* Retornar um redirected com um Header com a new location *====== */
		HttpHeaders headers = new HttpHeaders(); //org.springframework.http.HttpHeaders
		headers.add(HttpHeaders.LOCATION,"http://localhost:8080/cozinhas");
		return ResponseEntity
				.status(HttpStatus.FOUND)
				.headers(headers)
				.build();
	}
	
}
