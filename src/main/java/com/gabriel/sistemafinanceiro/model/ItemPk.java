package com.gabriel.sistemafinanceiro.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class ItemPk implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 Long id;
	
	 Long venda_cod;
	
}
