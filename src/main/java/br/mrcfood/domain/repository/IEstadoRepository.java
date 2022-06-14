package br.mrcfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.mrcfood.domain.entity.Estado;

public interface IEstadoRepository extends JpaRepository<Estado, Long>{
	
	
}
