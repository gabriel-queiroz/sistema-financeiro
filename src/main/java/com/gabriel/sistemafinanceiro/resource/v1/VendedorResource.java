package com.gabriel.sistemafinanceiro.resource.v1;

import javax.validation.constraints.NotNull;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import com.gabriel.sistemafinanceiro.model.Status;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Relation(value = "vendedor", collectionRelation = "vendedores")
public class VendedorResource  extends ResourceSupport{
			
		
	private Long codigo;
	
	@NotNull
	private String nome;
	
	private Status status;
	
	
}
