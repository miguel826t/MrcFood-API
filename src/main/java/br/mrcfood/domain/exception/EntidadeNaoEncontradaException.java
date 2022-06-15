package br.mrcfood.domain.exception;

public class EntidadeNaoEncontradaException extends RuntimeException{
	private static final long serialVersionUID = -8326033424575336834L;

	public EntidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
}
