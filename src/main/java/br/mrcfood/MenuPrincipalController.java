package br.mrcfood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.mrcfood.entities.Cliente;
import br.mrcfood.services.AtivarCliente;


@Controller
public class MenuPrincipalController {
	
	
	private AtivarCliente ativarCliente;
	
	public MenuPrincipalController(AtivarCliente ativarCliente) {
		this.ativarCliente = ativarCliente;
	}
	
	@GetMapping("/witam")
	@ResponseBody
	public String Witam() {
		Cliente cl = new Cliente(1,"MRC","sucesso");
		ativarCliente.ativar(cl);
		
		return "Witam!";
	}
	
}
