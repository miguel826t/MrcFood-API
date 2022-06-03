package br.mrcfood.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import br.mrcfood.entities.Cliente;

@TipoDoNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorEmail implements INotificador {

	private boolean caixaAlta;


	@Override
	public void notificar(Cliente cl, String msg) {
		if(this.caixaAlta) {
			msg = msg.toUpperCase();
		}
		
		System.out.println(msg+" Email");
	}

	public void setCaixaAlta(boolean caixaAlta) {
		this.caixaAlta = caixaAlta;
	}

}
