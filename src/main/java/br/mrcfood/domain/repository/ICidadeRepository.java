package br.mrcfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.mrcfood.domain.entity.Cidade;

public interface ICidadeRepository extends JpaRepository<Cidade, Long>{
	
	
}
