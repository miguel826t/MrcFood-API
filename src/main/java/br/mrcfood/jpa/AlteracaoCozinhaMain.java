package br.mrcfood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import br.mrcfood.MrcFoodApiApplication;
import br.mrcfood.domain.entity.Cozinha;

public class AlteracaoCozinhaMain {

	public static void main(String[] args) {
		
		//Executar com as configurações da WEB mas em DESKTOP
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(MrcFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		
		CadastroCozinha cd = applicationContext.getBean(CadastroCozinha.class);
		
		Cozinha cz = new Cozinha(1L,"Brasileira");
		
		cd.salvar(cz);
		
		
	}
}
