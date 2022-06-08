package br.mrcfood.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import br.mrcfood.domain.entity.Restaurante;
import br.mrcfood.domain.repository.IRestauranteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class RestauranteRepository implements IRestauranteRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Restaurante> buscalAll() {
		return manager.createQuery("from Restaurante",Restaurante.class).getResultList();
	}

	@Override
	public Restaurante buscarPorId(Long id) {
		return manager.find(Restaurante.class,id);
	}

	@Transactional
	@Override
	public Restaurante adicionar(Restaurante rt) {
		return manager.merge(rt);
	}

	@Transactional
	@Override
	public void remover(Long id) {
		Restaurante cozinha = buscarPorId(id);
		manager.remove(cozinha);
	}

	
	
}
