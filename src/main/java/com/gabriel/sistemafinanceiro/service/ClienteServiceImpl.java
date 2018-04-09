package com.gabriel.sistemafinanceiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.sistemafinanceiro.exceptions.ClienteNotFoundException;
import com.gabriel.sistemafinanceiro.model.Cliente;
import com.gabriel.sistemafinanceiro.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> listAll() {
		
		return clienteRepository.findAll();
	}

	@Override
	public Cliente getById(Long id) {
		
	return	clienteRepository.findById(id)
					.orElseThrow(() -> new ClienteNotFoundException());
		
	}

	@Override
	public Cliente save(Cliente cliente) {
		
		return clienteRepository.save(cliente);
		
	}

	@Override
	public Cliente update(Long id, Cliente cliente) {
		
		clienteExiste(id);
		
		cliente.setId(id);
		
		return	clienteRepository.save(cliente);
		
		
	}
	
	private Cliente clienteExiste(Long id) {
		
		return this.getById(id);
		
	}
	

}
