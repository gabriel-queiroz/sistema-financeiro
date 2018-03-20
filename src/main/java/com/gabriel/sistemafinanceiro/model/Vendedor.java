package com.gabriel.sistemafinanceiro.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Vendedor {
	
	@Id @GeneratedValue
	private Long id;
	
	@NotNull
	@Size(min = 5)
	private String nome;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;

	
	
	
}
