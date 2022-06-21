package br.mrcfood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mrcfood.domain.entity.Restaurante;
import br.mrcfood.infrastructure.repository.RestauranteRepository;

@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteRepository restaurantes;
	
	public List<Restaurante> ListarAll(){
		return restaurantes.buscarAll();
	}
	
	public Restaurante buscarPorId(Long id) {
		return restaurantes.buscarPorId(id);
	}
	
	public Restaurante criar(Restaurante restaurante) {
		return restaurantes.adicionar(restaurante);
	}
	
}
