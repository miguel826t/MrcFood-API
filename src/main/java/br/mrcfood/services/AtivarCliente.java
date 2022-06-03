package br.mrcfood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mrcfood.entities.Cliente;

@Component
public class AtivarCliente {

	@Autowired
	private INotificador notificador;
	
	@Autowired
	public AtivarCliente(INotificador notificador) {
		this.notificador = notificador;
	}
	
	public void ativar(Cliente cliente) {
		notificador.notificar(cliente, "teste");
	}
	
	@Autowired
	public void setNotificador(INotificador notificador) {
		this.notificador = notificador;
	}
	
	
}
