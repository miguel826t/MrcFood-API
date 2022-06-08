package br.mrcfood.domain.repository;

import java.util.List;

import br.mrcfood.domain.entity.Restaurante;

public interface IRestauranteRepository {
	
	List<Restaurante> buscalAll();
	Restaurante buscarPorId(Long id);
	Restaurante adicionar(Restaurante rt);
	void remover (Long id);
	
}
