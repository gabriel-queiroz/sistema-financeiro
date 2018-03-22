package com.gabriel.sistemafinanceiro.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.sistemafinanceiro.exceptions.PedidoNotFoundExeption;
import com.gabriel.sistemafinanceiro.model.Estado;
import com.gabriel.sistemafinanceiro.model.Pedido;
import com.gabriel.sistemafinanceiro.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	private PedidoRepository PedidoRepository; 
	
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
		
		pedido.setEstado(Estado.ANDAMENTO);
		pedido.setLucro(new BigDecimal(0));
		pedido.setValor(new BigDecimal(0));
		
		return this.PedidoRepository.save(pedido);
		
	}

	@Override
	public Pedido update(Long codigo,Pedido pedido) {
		
		pedido.setCodigo(codigo);
		
		return	this.PedidoRepository.save(pedido);
		
	}

	

}
