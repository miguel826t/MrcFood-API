package br.mrcfood.infrastructure.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.mrcfood.domain.entity.Restaurante;
import br.mrcfood.domain.repository.IRestauranteRepositoryQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class IRestauranteRepositoryImpl implements IRestauranteRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Restaurante> find(String nome,BigDecimal taxaInicial,BigDecimal taxaFinal){
		
		String jpql = "from Restaurante where reNome like :nome "
				+ "and reTxFrete between :taxaInicial and :taxaFinal ";
		
		return manager.createQuery(jpql,Restaurante.class)
				.setParameter("nome","%"+nome+"%")
				.setParameter("taxaInicial", taxaInicial)
				.setParameter("taxaFinal", taxaFinal)
				.getResultList();
	}
}
