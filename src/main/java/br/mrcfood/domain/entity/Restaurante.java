package br.mrcfood.domain.entity;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class Restaurante {

	//@GeneratedValue(strategy) não funciona DBMAKER não tem essa funciona de auto gerenciar a chave
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	private Long reId;
	
	private String reNome;
	
	@Column(name = "taxa_frete")
	private BigDecimal reTxFrete;

	/* ======* GET AND SET *====== */
	public Long getId() {
		return reId;
	}

	public void setId(Long id) {
		this.reId = id;
	}

	public String getNome() {
		return reNome;
	}

	public void setNome(String reNome) {
		this.reNome = reNome;
	}

	public BigDecimal getTaxaFrete() {
		return reTxFrete;
	}

	public void setTaxaFrete(BigDecimal reTxFrete) {
		this.reTxFrete = reTxFrete;
	}

	/* ======* EQUALS AND HASCODE *====== */
	@Override
	public int hashCode() {
		return Objects.hash(reId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurante other = (Restaurante) obj;
		return Objects.equals(reId, other.reId);
	}
	
}
