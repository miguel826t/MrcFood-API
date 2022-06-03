package br.mrcfood.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.mrcfood.services.AtivarCliente;
import br.mrcfood.services.NotificadorEmail;

@Configuration
public class MrcConfig {

	@Bean
	public NotificadorEmail notificadorEmail() {
		NotificadorEmail notificador = new NotificadorEmail("smtp.mrcGmail.com.br");
		notificador.setCaixaAlta(true);
		return notificador;
	}

	@Bean
	public AtivarCliente ativarCliente() {
		return new AtivarCliente(notificadorEmail());
	}
	
	
}
