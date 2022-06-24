package br.mrcfood.domain.repository;

import java.util.List;

import br.mrcfood.domain.entity.Cozinha;

public interface ICozinhaRepository {
	
	List<Cozinha> buscarAll();
	Cozinha buscarPorId(Long id);
	List<Cozinha> buscarPorNome(String nome);
	Cozinha adicionar(Cozinha cz);
	void remover (Long id);
	
}
