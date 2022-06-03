package br.mrcfood.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.mrcfood.entities.Cliente;

@Profile("prod")
@TipoDoNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorEmail implements INotificador {

	@Value("${notificador.email.host-servidor}")
	private String host;
	@Value("${notificador.email.porta-servidor}")
	private Integer porta;
	
	public NotificadorEmail() {
		System.out.println("real");
	}

	@Override
	public void notificar(Cliente cl, String msg) {
		System.out.println("host: "+host);
		System.out.println("porta: "+porta);
		System.out.println(cl.getNome() + msg);
	}

}
