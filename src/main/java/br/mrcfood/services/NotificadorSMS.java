package br.mrcfood.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import br.mrcfood.entities.Cliente;
import br.mrcfood.services.interfaces.INotificador;

@TipoDoNotificador(NivelUrgencia.NORMAL)
@Component
public class NotificadorSMS implements INotificador {

	private boolean caixaAlta;

	
	@Override
	public void notificar(Cliente cl, String msg) {
		if(this.caixaAlta) {
			msg = msg.toUpperCase();
		}
		
		System.out.println(msg+" SMS");
	}

	public void setCaixaAlta(boolean caixaAlta) {
		this.caixaAlta = caixaAlta;
	}

}
