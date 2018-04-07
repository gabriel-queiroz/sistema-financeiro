package com.gabriel.sistemafinanceiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gabriel.sistemafinanceiro.model.Status;
import com.gabriel.sistemafinanceiro.model.Vendedor;
import com.gabriel.sistemafinanceiro.repository.VendedorRepository;

public class VendedorServiceImpl implements VendedorService {

	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Override
	public List<Vendedor> listAll() {
		
		return this.vendedorRepository.findAll();
		
	}
	
	@Override
	public Vendedor getByCodigo(Long codigo) {
		
	return this.vendedorRepository
				    .findById(codigo)
				    .orElseThrow(
				    		() -> 
				    		new IllegalArgumentException("vendedor não encontrado"));
		
	}

	@Override
	public Vendedor save(Vendedor vendedor) {
		
		return this.vendedorRepository.save(vendedor);
		
	}
	
	@Override
	public Vendedor update(Long codigo, Vendedor vendedor) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void updateStatus(Long codigo, Status status) {
		
		Vendedor vendedor = this.getByCodigo(codigo);
		
		vendedor.setStatus(status);
		
		update(codigo, vendedor);
		
	}


	
	
	

}
