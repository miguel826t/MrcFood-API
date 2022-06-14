package br.mrcfood.infrastructure.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.mrcfood.domain.entity.Estado;
import br.mrcfood.domain.repository.IEstadoRepository;

@Repository
public class EstadoRepository {

	@Autowired
	private IEstadoRepository repository;
	
	public List<Estado> BuscarTodes(){
		return repository.findAll();
	}
	
	public Estado buscarPorId(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public Estado adicionar(Estado cd) {
		return repository.save(cd);
	}
	
	public void remover(Long id) {
		Estado cd = buscarPorId(id);
		repository.delete(cd);
	}
	
}