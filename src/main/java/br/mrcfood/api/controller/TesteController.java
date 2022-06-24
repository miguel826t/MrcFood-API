package br.mrcfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.mrcfood.domain.entity.Cozinha;
import br.mrcfood.infrastructure.repository.CozinhaRepository;

@RestController
@RequestMapping("/testes")
public class TesteController {
	
	@Autowired
	private CozinhaRepository cozinhas;
	
	@GetMapping("/cozinhas/por-nome")
	public List<Cozinha> cozinhasPorNome(@RequestParam("nome") String nome){
		return cozinhas.buscarPorNome(nome);
	}
	
	
	
	
	
}
