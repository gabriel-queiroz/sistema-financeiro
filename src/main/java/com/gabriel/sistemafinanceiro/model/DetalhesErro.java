package com.gabriel.sistemafinanceiro.model;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DetalhesErro {

	private String titulo;
	
	private HttpStatus httpStatus;
	
	private Long timestamp;
}