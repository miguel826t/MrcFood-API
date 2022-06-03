package br.mrcfood.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.mrcfood.entities.Cliente;

@Profile("develop")
@TipoDoNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorEmailMock implements INotificador {

	public NotificadorEmailMock() {
		System.out.println("Mock");
	}
	
	@Override
	public void notificar(Cliente cl, String msg) {

		System.out.println(msg+" Email");
	}


}
