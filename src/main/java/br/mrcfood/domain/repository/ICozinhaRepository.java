package br.mrcfood.domain.repository;

import java.util.List;

import br.mrcfood.domain.entity.Cozinha;

public interface ICozinhaRepository {
	
	List<Cozinha> buscalAll();
	Cozinha buscarPorId(Long id);
	Cozinha adicionar(Cozinha cz);
	void remover (Long id);
	
}
