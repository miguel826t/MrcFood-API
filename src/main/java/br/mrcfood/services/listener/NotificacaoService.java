package br.mrcfood.services.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.mrcfood.services.INotificador;
import br.mrcfood.services.NivelUrgencia;
import br.mrcfood.services.TipoDoNotificador;
import br.mrcfood.services.events.ClienteAtivoEvent;

@Component
public class NotificacaoService {
	
	@TipoDoNotificador(NivelUrgencia.URGENTE)
	@Autowired
	private INotificador notificador;
	
	@EventListener
	public void clienteAtivadoListener(ClienteAtivoEvent event) {
		notificador.notificar(event.getCliente()," seu cadastro está ativo!");
	}
	
	
	
}
