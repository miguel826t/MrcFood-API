package br.mrcfood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mrcfood.domain.entity.Cidade;
import br.mrcfood.domain.exception.EntidadeEmUsoException;
import br.mrcfood.domain.exception.EntidadeNaoEncontradaException;
import br.mrcfood.domain.service.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;

	@GetMapping
	public List<Cidade> listar() {
		return cidadeService.buscarAll();
	}

	@GetMapping(value = "/{cidadeId}")
	public ResponseEntity<Cidade> buscarPorId(@PathVariable Long cidadeId) {

		Cidade cidade = cidadeService.buscarPorId(cidadeId);
		if (cidade == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(cidade);
	}

	@PostMapping
	public ResponseEntity<?> criar(@RequestBody Cidade cidade) {
		try {
			cidade = cidadeService.criar(cidade);
			return ResponseEntity.status(HttpStatus.CREATED).body(cidade);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@PutMapping(value = "/{cidadeId}")
	public ResponseEntity<?> atualizar(@PathVariable Long cidadeId, @RequestBody Cidade cidade) {

		Cidade cidadeAtual = cidadeService.buscarPorId(cidadeId);
		if (cidadeAtual == null) {
			return ResponseEntity.notFound().build();
		}

		BeanUtils.copyProperties(cidade, cidadeAtual, "id");
		try {
			cidadeAtual = cidadeService.atualizar(cidadeAtual);
			return ResponseEntity.ok(cidadeAtual);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping(value = "/{cidadeId}")
	public ResponseEntity<?> remover(@PathVariable Long cidadeId){
		try {
			cidadeService.remover(cidadeId);
		}catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
	
}
