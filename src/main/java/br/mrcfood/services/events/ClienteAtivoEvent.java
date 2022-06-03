package br.mrcfood.services.events;

import br.mrcfood.entities.Cliente;

public class ClienteAtivoEvent {

	private Cliente cliente;

	public ClienteAtivoEvent(Cliente cliente) {
		super();
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	
	
}
