package br.mrcfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.mrcfood.domain.entity.Restaurante;

public interface IRestauranteRepository extends JpaRepository<Restaurante,Long> {

	
}
