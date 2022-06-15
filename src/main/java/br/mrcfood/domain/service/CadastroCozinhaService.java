package br.mrcfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mrcfood.domain.entity.Cozinha;
import br.mrcfood.infrastructure.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {

	@Autowired
	private CozinhaRepository cozinhas;
	
	
	public Cozinha criar(Cozinha cozinha) {
		return cozinhas.adicionar(cozinha);
	}
}
