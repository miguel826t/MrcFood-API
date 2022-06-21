package br.mrcfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.mrcfood.domain.entity.Estado;

public interface IEstadoRepository extends JpaRepository<Estado, Long>{
	
	//Estado findTopByOrderByIdDesc(); |> Seria para buscar o ultimo ID e adicionar +1 na hora de gravar, mas no DBMAKER não funciona
}
