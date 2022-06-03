/**
 * AUTHOR. M.R.C. - 05/22.
 *
 * Classe com metodos de configuracao de inicializacao da aplicacao
 */
package br.mrcfood.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import br.mrcfood.services.AtivarCliente;
import br.mrcfood.services.NotificadorEmail;

// Anotacao @Configuration é que diz ao Spring que esta classe é a config
// Que é onde fica os metodos de instanciacao e configuracao padrao dos objetos
@Configuration
public class AppConfig {

	// Metodo indica como sera a instanciacao e configuracao
	// Padrao que o Spring deve usar para este objeto
	@Bean
	public NotificadorEmail notificadorEmail() {
		// Instanciamos a classe passando um Host padrao para toda a aplicacao
		NotificadorEmail notificador = new NotificadorEmail("smtp.mrcGmail.com.br");
		// Setado por padrao caixa alta para todas as mensagens
		notificador.setCaixaAlta(true);
		
		//Retorna a classe configurada
		return notificador;
	}

	// Metodo configura para que o AtivarCliente use como padrao
	// a notificacao por email (notificadorEmail)
	@Bean
	public AtivarCliente ativarCliente() {
		return new AtivarCliente(notificadorEmail());
	}
	
	
}
