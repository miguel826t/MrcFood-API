package br.mrcfood.domain.entity;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {

	//@GeneratedValue(strategy) não funciona DBMAKER não tem essa funciona de auto gerenciar a chave
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@EqualsAndHashCode.Include
	@Id
	private Long reId;
	
	private String reNome;
	
	@Column(name = "taxa_frete")
	private BigDecimal reTxFrete;

}
