package com.gabriel.sistemafinanceiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.sistemafinanceiro.exceptions.FornecedorNotFoundException;
import com.gabriel.sistemafinanceiro.model.Fornecedor;
import com.gabriel.sistemafinanceiro.model.Status;
import com.gabriel.sistemafinanceiro.repository.FornecedorRepository;

@Service
public class FornecedorServiceImpl implements FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Override
	public Fornecedor getById(Long codigo) {
	
	return this.fornecedorRepository
			    .findById(codigo)
			    .orElseThrow(()  ->
			    
			    new FornecedorNotFoundException("fornecedor com codigo: " + codigo + " não encontrado")
			    
			    );
		
	}

	@Override
	public Fornecedor save(Fornecedor fornecedor) {
		
		fornecedor.setStatus(Status.ATIVO);
		
		return this.fornecedorRepository.save(fornecedor);
		
	}

	@Override
	public Fornecedor update(Long codigo, Fornecedor fornecedor) {
		
	fornecedor.setCodigo(codigo);
	fornecedor.setStatus(Status.ATIVO);
		
	return	this.fornecedorRepository.save(fornecedor);
		
		
	}

	@Override
	public List<Fornecedor> listAll() {
		
		return this.fornecedorRepository.findAll();
		
	}

	@Override
	public void statusUpdate(Long codigo, Status status) {
		
		Fornecedor fornecedor = this.fornecedorRepository.findById(codigo).get();
		
		fornecedor.setStatus(status);
		
		this.fornecedorRepository.save(fornecedor);
		
	}

}
