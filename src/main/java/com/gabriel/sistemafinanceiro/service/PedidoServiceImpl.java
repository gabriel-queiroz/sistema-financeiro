package com.gabriel.sistemafinanceiro.service;

import static java.util.Objects.isNull;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.sistemafinanceiro.exceptions.FornecedorNotFoundException;
import com.gabriel.sistemafinanceiro.exceptions.PedidoNotFoundExeption;
import com.gabriel.sistemafinanceiro.model.Estado;
import com.gabriel.sistemafinanceiro.model.Fornecedor;
import com.gabriel.sistemafinanceiro.model.Pedido;
import com.gabriel.sistemafinanceiro.repository.FornecedorRepository;
import com.gabriel.sistemafinanceiro.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	private PedidoRepository PedidoRepository; 
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Override
	public List<Pedido> listAll() {
		
		return this.PedidoRepository.findAll();
		
	}
	
	@Override
	public Pedido getById(Long codigo) {
		
	 return	this.PedidoRepository
			 	.findById(codigo)
			 	.orElseThrow(
			 			() -> new PedidoNotFoundExeption("Pedido com código :" +codigo + 
			 			"não encontrado"));
		
	}

	@Override
	public Pedido save(Pedido pedido) {
		
		pedido.setFornecedor(validFornecedor(pedido));
		
		pedido.setEstado(Estado.ANDAMENTO);
		
		return this.PedidoRepository.save(pedido);
		
	}

	@Override
	public Pedido update(Long codigo,Pedido pedido) {
		
		pedido.setCodigo(codigo);
		
		pedido.setEstado(Estado.ANDAMENTO);
		
		return	this.PedidoRepository.save(pedido);
		
		
		
	}
	
	private Fornecedor validFornecedor(Pedido pedido) {
		
		Optional<Fornecedor> fornecedor = null;
			
		if(!isNull( pedido.getFornecedor().getCodigo())){
			
			fornecedor = this.fornecedorRepository
							.findById(pedido.getFornecedor().getCodigo());
			
		}
		
		if(!fornecedor.isPresent()) {
			
			throw new FornecedorNotFoundException("fornecedor não encontrado");
			
		}
		
		return fornecedor.get();
		
	}

	

}
