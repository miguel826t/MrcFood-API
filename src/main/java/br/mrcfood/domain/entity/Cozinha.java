package br.mrcfood.domain.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="Cozinha")
public class Cozinha implements Serializable{
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	private Long czId;
	
	@Column(name = "czNome", length = 30)
	private String czNome;
	
	
	public Cozinha(Long czId, String czNome) {
		super();
		this.czId = czId;
		this.czNome = czNome;
	}
	
	public Cozinha() {};
	
}
