package br.mrcfood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.mrcfood.domain.entity.Restaurante;

public interface IRestauranteRepository extends JpaRepository<Restaurante,Long> {

	List<Restaurante> findAllByreTxFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
	
	Optional<Restaurante> findFirstByreId(Long id);
	
}
