package com.gabriel.sistemafinanceiro.service;

import java.util.List;

import com.gabriel.sistemafinanceiro.model.Cliente;

public interface ClienteService {

	List<Cliente> listAll();
	
	Cliente getById(Long id);
	
	Cliente save(Cliente cliente);
	
	Cliente update(Long id,Cliente cliente);
	
	
	
}
