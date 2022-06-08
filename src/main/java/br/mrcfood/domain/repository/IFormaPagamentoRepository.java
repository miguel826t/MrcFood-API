package br.mrcfood.domain.repository;

import java.util.List;

import br.mrcfood.domain.entity.FormaPagamento;

public interface IFormaPagamentoRepository {

	List<FormaPagamento> buscarAll();
	FormaPagamento buscarPorId(Long id);
	FormaPagamento adicionar(FormaPagamento cz);
	void remover (Long id);
}
