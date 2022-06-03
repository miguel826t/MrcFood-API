package br.mrcfood.services.interfaces;

import br.mrcfood.entities.Cliente;


public interface INotificador {

	void notificar(Cliente cl, String msg);

}