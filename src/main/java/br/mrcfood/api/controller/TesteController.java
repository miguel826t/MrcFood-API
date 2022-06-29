package br.mrcfood.api.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.mrcfood.domain.entity.Cozinha;
import br.mrcfood.domain.entity.Restaurante;
import br.mrcfood.domain.repository.ICozinhaRepository;
import br.mrcfood.domain.repository.IRestauranteRepository;
import br.mrcfood.domain.service.RestauranteService;

@RestController
@RequestMapping("/testes")
public class TesteController {
	
	@Autowired
	private ICozinhaRepository cozinhas;
	
	@Autowired
	private RestauranteService restauranteService;
	
	@Autowired
	private IRestauranteRepository restaurantes;
	
	@GetMapping("/cozinhas/por-nome")
	public List<Cozinha> cozinhasPorNome(@RequestParam("nome") String nome){
		return cozinhas.findAllByczNome(nome);
	}
	
	@GetMapping("/cozinhas/por-nome-contendo")
	public List<Cozinha> cozinhasPorNomeContendo(String nome){
		return cozinhas.findAllByczNomeContaining(nome);
	}
	
	@GetMapping("/restaurante/por-taxa")
	public List<Restaurante> buscarRestaurantesPorTaxaFrete(BigDecimal taxaInicial,BigDecimal taxaFinal){
		return restauranteService.buscarTodosPorTaxaFrete(taxaInicial,taxaFinal);
	}
	
	@GetMapping("/restaurante/primeiro")
	public Optional<Restaurante> buscarPrimeiroRestaurante(Long id){
		return restaurantes.findFirstByreId(id);
	}
	
}
