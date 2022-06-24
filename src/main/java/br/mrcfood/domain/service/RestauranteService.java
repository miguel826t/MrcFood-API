package br.mrcfood.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mrcfood.domain.entity.Cozinha;
import br.mrcfood.domain.entity.Restaurante;
import br.mrcfood.domain.exception.EntidadeNaoEncontradaException;
import br.mrcfood.domain.repository.ICozinhaRepository;
import br.mrcfood.domain.repository.IRestauranteRepository;

@Service
public class RestauranteService {
	
	@Autowired
	private IRestauranteRepository restaurantes;
	
	@Autowired
	private ICozinhaRepository cozinhas;
	
	public List<Restaurante> ListarAll(){
		return restaurantes.findAll();
	}
	
	public Optional<Restaurante> buscarPorId(Long id) {
		return restaurantes.findById(id); 
	}
	
	public Restaurante criar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getCzId();
		
		Cozinha cozinha = cozinhas.findById(cozinhaId)
				.orElseThrow(()->new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de cozinha com o código %d informado.", cozinhaId)));
		
		restaurante.setCozinha(cozinha);
		
		return restaurantes.save(restaurante);
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
