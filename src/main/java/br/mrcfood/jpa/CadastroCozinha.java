package br.mrcfood.jpa;

import java.util.List;

import org.springframework.stereotype.Component;

import br.mrcfood.domain.entity.Cozinha;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Component
public class CadastroCozinha {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Cozinha> listar(){
		TypedQuery<Cozinha>query = manager.createQuery("from Cozinha",Cozinha.class);
		return query.getResultList();
	}
	
	
}
