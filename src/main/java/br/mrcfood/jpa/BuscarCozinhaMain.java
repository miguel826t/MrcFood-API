package br.mrcfood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import br.mrcfood.MrcFoodApiApplication;
import br.mrcfood.domain.entity.Cozinha;
import br.mrcfood.domain.repository.ICozinhaRepository;

public class BuscarCozinhaMain {

	public static void main(String[] args) {
		
		//Executar com as configurações da WEB mas em DESKTOP
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(MrcFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		
		ICozinhaRepository czRepo = applicationContext.getBean(ICozinhaRepository.class);
		Cozinha cz = czRepo.buscarPorId(1L);

		System.out.println(cz.getId());
		System.out.println(cz.getNome());
		
	}
}
