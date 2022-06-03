package br.mrcfood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.mrcfood.entities.Cliente;


@Component
public class AtivarCliente {

	// AutoInjecao (Ponto 1)
	@TipoDoNotificador(NivelUrgencia.URGENTE)
	@Autowired
	private INotificador notificador;
	
	// AutoInjecao (Ponto 2)
	// A anotacao no construtor indica que este é o construtor padrao que deve ser usado pelo spring
	// Isto quando haver mais de um construtor na classe
	// @Autowired(required = false) //torna esta dependencia opcional
	
	public void ativar(Cliente cliente) {
		
		notificador.notificar(cliente, "Cliente "+cliente.getNome()+ "ativado e notificado");
	}
	
}
