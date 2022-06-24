package br.mrcfood.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mrcfood.domain.repository.ICozinhaRepository;

@RestController
@RequestMapping("/testes")
public class TesteController {
	
	@Autowired
	private ICozinhaRepository cozinhas;
	
	//@GetMapping("/cozinhas/por-nome")
	//public List<Cozinha> cozinhasPorNome(@RequestParam("nome") String nome){
	//	return cozinhas.buscarPorNome(nome);
	//}
	
	
	
	
	
}
