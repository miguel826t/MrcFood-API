package br.mrcfood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import br.mrcfood.domain.entity.Restaurante;

public interface IRestauranteRepositoryQuery {

	List<Restaurante> find(String nome, BigDecimal taxaInicial, BigDecimal taxaFinal);

}