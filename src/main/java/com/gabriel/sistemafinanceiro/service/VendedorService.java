package com.gabriel.sistemafinanceiro.service;

import java.util.List;

import com.gabriel.sistemafinanceiro.model.Status;
import com.gabriel.sistemafinanceiro.model.Vendedor;

public interface VendedorService {
	
	List<Vendedor> listAll();
	
	Vendedor getByCodigo(Long codigo);
	
	Vendedor save(Vendedor vendedor);
	
	Vendedor update(Long codigo, Vendedor vendedor);
	
	void updateStatus(Long codigo, Status status);
	
	
	
}
