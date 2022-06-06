package br.mrcfood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.mrcfood.entities.Cliente;
import br.mrcfood.services.interfaces.INotificador;
import br.mrcfood.services.properties.NotificadorProperties;

@Profile("prod")
@TipoDoNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorEmail implements INotificador {

	@Autowired
	private NotificadorProperties properties;
	
	
	public NotificadorEmail() {
		System.out.println("real");
	}

	@Override
	public void notificar(Cliente cl, String msg) {
		System.out.println("host: "+properties.getHostServidor());
		System.out.println("porta: "+properties.getPortaServidor());
		System.out.println(cl.getNome() + msg);
	}
}
