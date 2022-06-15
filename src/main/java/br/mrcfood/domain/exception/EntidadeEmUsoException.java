package br.mrcfood.domain.exception;

public class EntidadeEmUsoException extends RuntimeException{
	private static final long serialVersionUID = -1092016079648648610L;

	public EntidadeEmUsoException(String mensagem) {
		super(mensagem);
	}
}
