package br.mrcfood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mrcfood.domain.entity.Cozinha;
import br.mrcfood.domain.entity.Restaurante;
import br.mrcfood.domain.exception.EntidadeNaoEncontradaException;
import br.mrcfood.infrastructure.repository.CozinhaRepository;
import br.mrcfood.infrastructure.repository.RestauranteRepository;

@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteRepository restaurantes;
	
	@Autowired
	private CozinhaRepository cozinhas;
	
	public List<Restaurante> ListarAll(){
		return restaurantes.buscarAll();
	}
	
	public Restaurante buscarPorId(Long id) {
		Restaurante restaurante = restaurantes.buscarPorId(id); 
		if(restaurante == null) {
			throw new EntidadeNaoEncontradaException(
					 String.format("Não existe um restaurante cadastrado com o código %d informado.", id));
		}
		return restaurante;
	}
	
	public Restaurante criar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getCzId();
		Cozinha cozinha = cozinhas.buscarPorId(cozinhaId);
		if(cozinha == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de cozinha com o código %d informado.", cozinhaId));
		}
		restaurante.setCozinha(cozinha);
		
		return restaurantes.adicionar(restaurante);
	}
	
	//public Restaurante atualizar(Long id,Restaurante restauranteAtualizado) {
	//	
	//	Restaurante restauranteAtual = buscarPorId(id);
	//	
	//	BeanUtils.copyProperties(restauranteAtualizado, restauranteAtual,"reId");
	//	
	//	restauranteAtualizado = criar(restauranteAtualizado);
	//	
	//	return restauranteAtualizado;
	//	
	//}
	
}
