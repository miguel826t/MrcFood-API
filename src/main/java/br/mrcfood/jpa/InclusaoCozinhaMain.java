package br.mrcfood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import br.mrcfood.MrcFoodApiApplication;
import br.mrcfood.domain.entity.Cozinha;

public class InclusaoCozinhaMain {

	public static void main(String[] args) {
		
		//Executar com as configurações da WEB mas em DESKTOP
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(MrcFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		
		CadastroCozinha cd = applicationContext.getBean(CadastroCozinha.class);
		
		// Como o DBMAKER não consegue ao incrementar o codigo(Id)
		// Aqui deveria ser lido o banco para saber o proximo Id
		Cozinha cozinha_1 = new Cozinha(3L,"microsoft");
		Cozinha cozinha_2 = new Cozinha(4L,"nintendo");
		cd.adicionar(cozinha_1);
		cd.adicionar(cozinha_2);
		
	}
}
