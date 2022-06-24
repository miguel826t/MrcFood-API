package br.mrcfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mrcfood.domain.entity.Cozinha;

@Repository
public interface ICozinhaRepository extends JpaRepository<Cozinha, Long>{

//	List<Cozinha> buscarPorNome(String nome);
	
}
