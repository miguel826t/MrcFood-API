package br.mrcfood.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante implements Serializable{
	private static final long serialVersionUID = 1L;

	//@GeneratedValue(strategy) não funciona DBMAKER não tem essa funciona de auto gerenciar a chave
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@EqualsAndHashCode.Include
	@Id
	private Long reId;
	
	private String reNome;
	
	@Column(name = "taxa_frete")
	private BigDecimal reTxFrete;

	@ManyToOne
	@JoinColumn(name = "cozinha_czid")
	private Cozinha cozinha;
}
