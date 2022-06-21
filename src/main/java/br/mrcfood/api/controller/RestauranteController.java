package br.mrcfood.api.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.mrcfood.domain.entity.Cozinha;
import br.mrcfood.domain.entity.Restaurante;
import br.mrcfood.domain.exception.EntidadeNaoEncontradaException;
import br.mrcfood.domain.service.CozinhaService;
import br.mrcfood.domain.service.RestauranteService;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController {
	
	@Autowired
	private RestauranteService restauranteService;
	
	@Autowired
	private CozinhaService cozinhaService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Restaurante> ListarAll(){
		return restauranteService.ListarAll();
	}
	
	@GetMapping(value = "/{restauranteId}")
	public ResponseEntity<Restaurante> buscarPorId(@PathVariable Long restauranteId){
		Restaurante restaurante = restauranteService.buscarPorId(restauranteId);
		if(restaurante == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(restaurante);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {
		try {
			restaurante = restauranteService.criar(restaurante);
			return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
