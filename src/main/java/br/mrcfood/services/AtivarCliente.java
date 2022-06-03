package br.mrcfood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mrcfood.entities.Cliente;




@Component
public class AtivarCliente {

	// AutoInjecao (Ponto 1)
	//@Autowired
	private INotificador notificador;
	
	// AutoInjecao (Ponto 2)
	// A anotacao no construtor indica que este é o construtor padrao que deve ser usado pelo spring
	// Isto quando haver mais de um construtor na classe
	@Autowired
	public AtivarCliente(INotificador notificador) {
		this.notificador = notificador;
	}
	
	public void ativar(Cliente cliente) {
		notificador.notificar(cliente, "Cliente ativado com sucesso");
	}
	
	// AutoInjecao (Ponto 3)
	//@Autowired
	public void setNotificador(INotificador notificador) {
		this.notificador = notificador;
	}
	
	
}
