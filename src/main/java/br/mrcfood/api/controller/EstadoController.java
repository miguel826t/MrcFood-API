package br.mrcfood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.mrcfood.domain.entity.Estado;
import br.mrcfood.domain.exception.EntidadeEmUsoException;
import br.mrcfood.domain.exception.EntidadeNaoEncontradaException;
import br.mrcfood.domain.service.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {
	
	// GET all
	// GET id
	// POST - new
	// PUT - alterated
	// Delete - remover
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Estado> listar(){
		return estadoService.buscarAll();
	}
	
	@GetMapping("/{estadoId}")
	public ResponseEntity<Estado> buscar(@PathVariable("estadoId") Long id) {
		try {
			Estado estado = estadoService.buscarPorId(id);
			return ResponseEntity.ok(estado);
		}catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Estado criar(@RequestBody Estado estado) {
		return estadoService.criar(estado);
	}
	
	@PutMapping("/{estadoId}")
	public ResponseEntity<Estado> atualizar(@PathVariable Long estadoId,@RequestBody Estado estadoAtualizado) {
		
		Estado estadoAtual = new Estado();
		try {
			estadoAtual = estadoService.buscarPorId(estadoId);			
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}

		
		BeanUtils.copyProperties(estadoAtualizado, estadoAtual,"id");
		estadoAtual = estadoService.criar(estadoAtual);
		return ResponseEntity.ok(estadoAtual);
	}
	
	@DeleteMapping("/{estadoId}")
	public ResponseEntity<?> remover(@PathVariable Long estadoId){
		try {
			estadoService.remover(estadoId);
			return ResponseEntity.noContent().build();
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
}
