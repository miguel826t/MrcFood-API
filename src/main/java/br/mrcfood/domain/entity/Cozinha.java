package br.mrcfood.domain.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@JsonRootName("cozinha")
@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="Cozinha")
public class Cozinha implements Serializable{
	private static final long serialVersionUID = 1L;

	//@JsonIgnore
	@EqualsAndHashCode.Include
	@Id
	private Long czId;
	
	
	@JsonProperty("titulo")
	@Column(name = "czNome", length = 30)
	private String czNome;
	
	
	public Cozinha(Long czId, String czNome) {
		super();
		this.czId = czId;
		this.czNome = czNome;
	}
	
	public Cozinha() {};
	
}
