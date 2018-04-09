package com.gabriel.sistemafinanceiro.exceptions;

public class ClienteNotFoundException extends RuntimeException {
	
	private static String message = "Cliente não encontrado";
	
	public ClienteNotFoundException(String message) {
		super(message);
	}
	
	public ClienteNotFoundException() {
		
		super(message);
		
		
		
		
	}
	
}
