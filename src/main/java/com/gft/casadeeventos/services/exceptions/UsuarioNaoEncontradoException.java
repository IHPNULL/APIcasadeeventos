package com.gft.casadeeventos.services.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException{

	
	private static final long serialVersionUID = -6914769072363653212L;

	public UsuarioNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public UsuarioNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
