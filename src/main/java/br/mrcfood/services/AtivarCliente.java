package br.mrcfood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import br.mrcfood.entities.Cliente;
import br.mrcfood.services.events.ClienteAtivoEvent;


@Component
public class AtivarCliente {

	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	
	public void ativar(Cliente cliente) {
		cliente.Ativar();
		eventPublisher.publishEvent(new ClienteAtivoEvent(cliente));
		
	}
	
}
