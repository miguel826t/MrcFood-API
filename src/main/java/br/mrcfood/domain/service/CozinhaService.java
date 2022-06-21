package br.mrcfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.mrcfood.domain.entity.Cozinha;
import br.mrcfood.domain.exception.EntidadeEmUsoException;
import br.mrcfood.domain.exception.EntidadeNaoEncontradaException;
import br.mrcfood.infrastructure.repository.CozinhaRepository;

@Service
public class CozinhaService {

	@Autowired
	private CozinhaRepository cozinhas;
	
	
	public Cozinha criar(Cozinha cozinha) {
		return cozinhas.adicionar(cozinha);
	}
	
	public Cozinha buscarPorId(Long id) {
		return cozinhas.buscarPorId(id);
	}
	
	public void remover(Long cozinhaId) {
		try {
			cozinhas.remover(cozinhaId);			
		}catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cozinha de código %d não pode ser removida, pois está em uso",cozinhaId));
		}catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cozinha com código %d",cozinhaId));
		}
	}
	
	
	
	
}
