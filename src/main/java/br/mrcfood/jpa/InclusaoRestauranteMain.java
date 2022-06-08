package br.mrcfood.jpa;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import br.mrcfood.MrcFoodApiApplication;
import br.mrcfood.domain.entity.Restaurante;
import br.mrcfood.domain.repository.IRestauranteRepository;

public class InclusaoRestauranteMain {

	public static void main(String[] args) {
		
		//Executar com as configurações da WEB mas em DESKTOP
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(MrcFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		
		IRestauranteRepository repo = applicationContext.getBean(IRestauranteRepository.class);
		
		// Como o DBMAKER não consegue ao incrementar o codigo(Id)
		// Aqui deveria ser lido o banco para saber o proximo Id
		Restaurante cozinha_1 = new Restaurante(4L,"Eua texas",new BigDecimal("10.0"),null);
		Restaurante cozinha_2 = new Restaurante(5L,"mexida br",new BigDecimal("5.4"),null);
		repo.adicionar(cozinha_1);
		repo.adicionar(cozinha_2);
		
	}
}
