package br.mrcfood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.mrcfood.domain.entity.Cidade;
import br.mrcfood.domain.entity.Estado;
import br.mrcfood.domain.exception.EntidadeEmUsoException;
import br.mrcfood.domain.exception.EntidadeNaoEncontradaException;
import br.mrcfood.infrastructure.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidades;

	@Autowired
	private EstadoService estadoService;

	public List<Cidade> buscarAll() {
		return cidades.BuscarTodes();
	}

	public Cidade buscarPorId(Long id) {
		return cidades.buscarPorId(id);
	}

	public Cidade criar(Cidade cidade) {

		Cidade cidadeJaExiste = cidades.buscarPorId(cidade.getId());
		if (cidadeJaExiste != null) {
			throw new EntidadeEmUsoException(String.format("Cidade informada já existe cadastrada", cidade.getId()));
		}

		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoService.buscarPorId(estadoId);
		if (estado == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um estado com o código %d informado", estadoId));
		}
		cidade.setEstado(estado);

		return cidades.adicionar(cidade);
	}

	public Cidade atualizar(Cidade cidade) {

		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoService.buscarPorId(estadoId);
		if (estado == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um estado com o código %d informado", estadoId));
		}
		cidade.setEstado(estado);

		return cidades.adicionar(cidade);
	}

	public void remover(Long id) {
		try {
			cidades.remover(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cidade com código %d", id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cidade de código %d não pode ser removida, pois está em uso", id));
		}
	}

}
