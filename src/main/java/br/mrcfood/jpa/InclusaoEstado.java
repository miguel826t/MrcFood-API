package br.mrcfood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import br.mrcfood.MrcFoodApiApplication;
import br.mrcfood.domain.entity.Estado;
import br.mrcfood.infrastructure.repository.EstadoRepository;


public class InclusaoEstado {

	public static void main(String[] args) {
		
		//Executar com as configurações da WEB mas em DESKTOP
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(MrcFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		
		EstadoRepository estados = applicationContext.getBean(EstadoRepository.class);
		
		// Como o DBMAKER não consegue ao incrementar o codigo(Id)
		// Aqui deveria ser lido o banco para saber o proximo Id
		Estado estado = new Estado();
		estado.setNome("mato grosso");
		
		estados.adicionar(estado);
		
	}
}
