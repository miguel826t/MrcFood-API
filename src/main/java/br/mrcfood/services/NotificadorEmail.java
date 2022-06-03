package br.mrcfood.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.mrcfood.entities.Cliente;

@Profile("prod")
@TipoDoNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorEmail implements INotificador {

	public NotificadorEmail() {
		System.out.println("real");
	}

	@Override
	public void notificar(Cliente cl, String msg) {
		System.out.println(cl.getNome() + msg);
	}

}
