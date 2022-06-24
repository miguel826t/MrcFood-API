package br.mrcfood.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.mrcfood.domain.entity.Cidade;
import br.mrcfood.domain.entity.Estado;
import br.mrcfood.domain.exception.EntidadeEmUsoException;
import br.mrcfood.domain.exception.EntidadeNaoEncontradaException;
import br.mrcfood.domain.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidades;

	@Autowired
	private EstadoService estadoService;

	public List<Cidade> buscarAll() {
		return cidades.findAll();
	}

	public Optional<Cidade> buscarPorId(Long id) {
		return cidades.findById(id);
	}

	public Cidade criar(Cidade cidade) {

		Optional<Cidade> cidadeExiste = buscarPorId(cidade.getId());
		if (cidadeExiste.isPresent()) {
			throw new EntidadeEmUsoException(String.format("Cidade informada já existe cadastrada", cidade.getId()));
		}

		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoService.buscarPorId(estadoId);
		if (estado == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um estado com o código %d informado", estadoId));
		}
		cidade.setEstado(estado);

		return cidades.save(cidade);
	}

	public Cidade atualizar(Cidade cidade) {

		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoService.buscarPorId(estadoId);
		if (estado == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um estado com o código %d informado", estadoId));
		}
		cidade.setEstado(estado);

		return cidades.save(cidade);
	}

	public void remover(Long id) {
		try {
			cidades.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cidade com código %d", id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cidade de código %d não pode ser removida, pois está em uso", id));
		}
	}

}
