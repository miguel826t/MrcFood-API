package br.mrcfood.services;

import br.mrcfood.entities.Cliente;


public class NotificadorEmail implements INotificador {

	private boolean caixaAlta;
	private String hostService;
	
	public NotificadorEmail(String hostService) {
		this.hostService = hostService;
	}
	
	@Override
	public void notificar(Cliente cl, String msg) {
		if(this.caixaAlta) {
			msg = msg.toUpperCase();
		}
		System.out.println(msg);
	}

	public void setCaixaAlta(boolean caixaAlta) {
		this.caixaAlta = caixaAlta;
	}
}
