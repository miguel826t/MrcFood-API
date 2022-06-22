package br.mrcfood.infrastructure.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import br.mrcfood.domain.entity.Cidade;
import br.mrcfood.domain.repository.ICidadeRepository;

@Repository
public class CidadeRepository {

	@Autowired
	private ICidadeRepository repository;
	
	public List<Cidade> BuscarTodes(){
		return repository.findAll();
	}
	
	public Cidade buscarPorId(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public Cidade adicionar(Cidade cd) {
		return repository.save(cd);
	}
	
	public void remover(Long id) {
		Cidade cd = buscarPorId(id);
		if(cd == null) {
			throw new EmptyResultDataAccessException(1);
		}
		repository.delete(cd);
	}
	
}
