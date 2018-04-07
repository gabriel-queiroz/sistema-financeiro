package com.gabriel.sistemafinanceiro.resource.v1;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gabriel.sistemafinanceiro.model.Estado;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Relation(value ="pedido", collectionRelation ="pedidos")
public class PedidoResource  extends ResourceSupport {

	
	private Long codigo;
	
	@NotNull
	private LocalDate dataChegada;
	
	@NotNull
	private LocalDate dataEnvio;
	
	@NotNull
	private LocalDate dataPagemento;
	
	
	private  Estado  estado;
	
	@NotNull
	private FornecedorResource fornecedor;
	
	
	private BigDecimal valor;
	
	
	private BigDecimal lucro;
}
