package br.mrcfood.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import br.mrcfood.domain.entity.Cozinha;
import br.mrcfood.domain.repository.ICozinhaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class CozinhaRepository implements ICozinhaRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cozinha> buscarAll() {
		return manager.createQuery("from Cozinha",Cozinha.class).getResultList();
	}

	@Override
	public Cozinha buscarPorId(Long id) {
		return manager.find(Cozinha.class,id);
	}

	@Transactional
	@Override
	public Cozinha adicionar(Cozinha cz) {
		return manager.merge(cz);
	}

	@Transactional
	@Override
	public void remover(Long id) {
		Cozinha cozinha = buscarPorId(id);
		if(cozinha == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		manager.remove(cozinha);
	}
}
