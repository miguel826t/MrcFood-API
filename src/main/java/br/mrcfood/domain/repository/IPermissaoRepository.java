package br.mrcfood.domain.repository;

import java.util.List;

import br.mrcfood.domain.entity.Permissao;

public interface IPermissaoRepository {

	List<Permissao> buscarAll();
	Permissao buscarPorId(Long id);
	Permissao adicionar(Permissao permissao);
	void remover (Long id);
	
}
