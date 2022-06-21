package br.mrcfood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.mrcfood.domain.entity.Estado;
import br.mrcfood.domain.exception.EntidadeEmUsoException;
import br.mrcfood.domain.exception.EntidadeNaoEncontradaException;
import br.mrcfood.infrastructure.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estados;

	public List<Estado> buscarAll() {
		return estados.BuscarTodes();
	}

	public Estado buscarPorId(Long id) {
		Estado estado = estados.buscarPorId(id);
		if (estado == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Estado informado com o código %d não existe cadastrado", id));
		}

		return estado;
	}

	public Estado criar(Estado estado) {
		return estados.adicionar(estado);
	}

	public void remover(Long id) {
		try {
			estados.remover(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Estado de código %d não pode ser removida, pois está em uso", id));
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de estado com código %d", id));
		}
	}
}
