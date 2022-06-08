package br.mrcfood.jpa;

import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import br.mrcfood.MrcFoodApiApplication;
import br.mrcfood.domain.entity.Cozinha;

public class ConsultarCozinhaMain {

	public static void main(String[] args) {
		
		//Executar com as configurações da WEB mas em DESKTOP
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(MrcFoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		
		CadastroCozinha cd = applicationContext.getBean(CadastroCozinha.class);
		List<Cozinha> cozinhas = cd.listar();
		
		for(Cozinha cz : cozinhas) {
			System.out.println(cz.getNome());
		}
	}
}
