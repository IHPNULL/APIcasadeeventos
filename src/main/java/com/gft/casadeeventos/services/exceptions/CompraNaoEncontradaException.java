package com.gft.casadeeventos.services.exceptions;

public class CompraNaoEncontradaException extends RuntimeException{

	
	private static final long serialVersionUID = -6914769072363653212L;

	public CompraNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public CompraNaoEncontradaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
