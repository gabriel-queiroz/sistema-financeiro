package com.gabriel.sistemafinanceiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.sistemafinanceiro.model.Status;
import com.gabriel.sistemafinanceiro.model.Vendedor;
import com.gabriel.sistemafinanceiro.repository.VendedorRepository;

@Service
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
		
		vendedor.setStatus(Status.ATIVO);
		
		return this.vendedorRepository.save(vendedor);
		
	}
	
	@Override
	public Vendedor update(Long codigo, Vendedor vendedor) {
		
		vendedor.setCodigo(codigo);
		
		vendedorExiste(vendedor.getCodigo());
		
		vendedor.setStatus(Status.ATIVO);
		
		return vendedorRepository.save(vendedor);
		
	}

	
	@Override
	public void updateStatus(Long codigo, Status status) {
		
		Vendedor vendedor = vendedorExiste(codigo);
		
		vendedor.setStatus(status);
		
		this.vendedorRepository.save(vendedor);
		
	}


	private Vendedor vendedorExiste(Long codigo) {
		
		return this.getByCodigo(codigo);
		
	}
	
	

}
