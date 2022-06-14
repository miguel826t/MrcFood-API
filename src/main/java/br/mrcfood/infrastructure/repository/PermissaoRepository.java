package br.mrcfood.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import br.mrcfood.domain.entity.Permissao;
import br.mrcfood.domain.repository.IPermissaoRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Component
public class PermissaoRepository implements IPermissaoRepository{

	private EntityManager manager;

	@Override
	public List<Permissao> buscarAll() {
		return manager.createQuery("from Permissao",Permissao.class).getResultList();
	}

	@Override
	public Permissao buscarPorId(Long id) {
		return manager.find(Permissao.class, id);
	}

	@Override
	@Transactional
	public Permissao adicionar(Permissao permissao) {
		return manager.merge(permissao);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		Permissao permissao = buscarPorId(id);
		manager.remove(permissao);
	}

	
	
	
	
	
}
