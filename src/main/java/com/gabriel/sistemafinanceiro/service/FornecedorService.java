package com.gabriel.sistemafinanceiro.service;

import java.util.List;

import com.gabriel.sistemafinanceiro.model.Fornecedor;
import com.gabriel.sistemafinanceiro.model.Status;

public interface FornecedorService {

	Fornecedor getById(Long codigo);
	
	Fornecedor save(Fornecedor fornecedor);
	
	Fornecedor update(Long codigo,Fornecedor fornecedor);
	
	void statusUpdate(Long codigo , Status status);
	
	List<Fornecedor> listAll();
	
}
