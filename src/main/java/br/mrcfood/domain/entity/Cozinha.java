package br.mrcfood.domain.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="Cozinha")
public class Cozinha {

	public Cozinha(Long czId, String czNome) {
		super();
		this.czId = czId;
		this.czNome = czNome;
	}
	public Cozinha() {
		
	}

	@Id
	private Long czId;
	
	@Column(name = "czNome", length = 30)
	private String czNome;


	
	/* ======* GET AND SET *====== */
	public Long getId() {
		return czId;
	}

	public void setId(Long id) {
		this.czId = id;
	}

	public String getNome() {
		return czNome;
	}

	public void setNome(String nome) {
		this.czNome = nome;
	}

	/* ======* EQUALS AND HASCODE *====== */
	@Override
	public int hashCode() {
		return Objects.hash(czId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cozinha other = (Cozinha) obj;
		return Objects.equals(czId, other.czId);
	}	
	
	
	
}
