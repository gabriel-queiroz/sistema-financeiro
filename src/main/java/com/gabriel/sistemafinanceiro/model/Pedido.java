package com.gabriel.sistemafinanceiro.model;


import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull
	private LocalDate dataChegada;
	
	@NotNull
	private LocalDate dataEnvio;
	
	@NotNull
	private  LocalDate dataPagemento;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private  Estado  estado;
		
	@NotNull
	@ManyToOne
	private Fornecedor fornecedor;
	
	private BigDecimal valor;

	private BigDecimal lucro;
	
	
	
}
