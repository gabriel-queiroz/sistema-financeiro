package com.gabriel.sistemafinanceiro.exceptions;

public class PedidoNotFoundExeption extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PedidoNotFoundExeption(String mensagem,Throwable causa) {
		
		super(mensagem,causa);
		
	}
	
	public PedidoNotFoundExeption(String mensagem) {
		
		super(mensagem);
	}
}
