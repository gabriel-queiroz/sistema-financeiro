package com.gabriel.sistemafinanceiro.resource.v1;

import java.math.BigDecimal;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import com.gabriel.sistemafinanceiro.model.Categoria;
import com.gabriel.sistemafinanceiro.model.Status;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Relation(value = "fornecedor" , collectionRelation = "fornecedores")
public class FornecedorResource extends ResourceSupport{
	
	private Long codigo;
	
	private String descricao;
	
	private Categoria categoria;
	
	private Status  status;
	
	private BigDecimal margemLucro;
	
}
