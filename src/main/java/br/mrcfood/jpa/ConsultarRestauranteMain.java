package br.mrcfood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import br.mrcfood.MrcFoodApiApplication;
import br.mrcfood.domain.entity.Restaurante;
import br.mrcfood.domain.repository.IRestauranteRepository;

public class ConsultarRestauranteMain {

	public static void main(String[] args) {
		
		//Executar com as configurações da WEB mas em DESKTOP
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(MrcFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		
		IRestauranteRepository czRepo = applicationContext.getBean(IRestauranteRepository.class);
		List<Restaurante> elus = czRepo.buscarAll();
		
		for(Restaurante elu : elus) {
			System.out.printf("%s - %f - %s \n",elu.getReNome(),elu.getReTxFrete(),elu.getCozinha().getCzNome());
		}
	}
}
