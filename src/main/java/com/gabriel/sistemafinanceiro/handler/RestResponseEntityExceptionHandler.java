package com.gabriel.sistemafinanceiro.handler;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gabriel.sistemafinanceiro.exceptions.FornecedorNotFoundException;
import com.gabriel.sistemafinanceiro.model.DetalhesErro;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = FornecedorNotFoundException.class)
	public ResponseEntity<DetalhesErro> handlerFornecedorNotFoundException(
			
			FornecedorNotFoundException e,
			HttpServletRequest req){
			
			DetalhesErro erro = DetalhesErro.builder()
			.titulo(e.getMessage())
			.httpStatus(HttpStatus.NOT_FOUND)
			.timestamp(System.currentTimeMillis()).build();
		
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
	}
	
}