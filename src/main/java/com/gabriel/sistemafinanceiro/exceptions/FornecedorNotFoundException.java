package com.gabriel.sistemafinanceiro.exceptions;

public class FornecedorNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FornecedorNotFoundException(String message, Throwable cause) {
		
		super(message, cause);
		
	}
	
	public FornecedorNotFoundException(String message) {
		
		super(message);
		
	}
	
	
}