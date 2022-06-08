package br.mrcfood.domain.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusPedido {
	CRIADO(1),
	CONFIRMADO(2),
	ENTREGUE(3),
	CANCELADO(4);
	
	private int code;
	
	public static StatusPedido valueOf(int code) {
		for(StatusPedido value : StatusPedido.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Valor requerido não é valido.");
	}
}
