package br.mrcfood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.mrcfood.domain.entity.Cozinha;

@Repository
public interface ICozinhaRepository extends JpaRepository<Cozinha, Long>{

	List<Cozinha> findAllByczNome(String nome);
	
	@Query("from Cozinha where czNome like %:nome%")
	List<Cozinha> buscarPorNome(@Param("nome") String nome);
	//List<Cozinha> findAllByczNomeContaining(String nome);
	
}
