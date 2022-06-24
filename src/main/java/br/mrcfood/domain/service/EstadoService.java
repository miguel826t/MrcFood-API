package br.mrcfood.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.mrcfood.domain.entity.Estado;
import br.mrcfood.domain.exception.EntidadeEmUsoException;
import br.mrcfood.domain.exception.EntidadeNaoEncontradaException;
import br.mrcfood.domain.repository.IEstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private IEstadoRepository estados;

	public List<Estado> buscarAll() {
		return estados.findAll();
	}

	public Optional<Estado> buscarPorId(Long id) {
		return estados.findById(id);
		
	}

	public Estado criar(Estado estado) {
		return estados.save(estado);
	}

	public void remover(Long id) {
		try {
			estados.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Estado de código %d não pode ser removida, pois está em uso", id));
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de estado com código %d", id));
		}
	}
}
