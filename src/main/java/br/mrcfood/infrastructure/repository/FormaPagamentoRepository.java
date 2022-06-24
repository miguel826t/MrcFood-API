package br.mrcfood.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.mrcfood.domain.entity.FormaPagamento;
import br.mrcfood.domain.repository.IFormaPagamentoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class FormaPagamentoRepository implements IFormaPagamentoRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<FormaPagamento> buscarAll() {
		return manager.createQuery("from FormaPagamento",FormaPagamento.class).getResultList();
	}

	@Override
	public FormaPagamento buscarPorId(Long id) {
		return manager.find(FormaPagamento.class,id);
	}

	@Transactional
	@Override
	public FormaPagamento adicionar(FormaPagamento cz) {
		return manager.merge(cz);
	}

	@Transactional
	@Override
	public void remover(Long id) {
		FormaPagamento cozinha = buscarPorId(id);
		manager.remove(cozinha);
	}

	
	
}
