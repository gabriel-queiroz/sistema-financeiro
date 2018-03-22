package com.gabriel.sistemafinanceiro.service;

import java.util.List;

import com.gabriel.sistemafinanceiro.model.Pedido;

public interface PedidoService {

	List<Pedido> listAll();
	
	Pedido save(Pedido pedido);
	
	Pedido update(Long codigo,Pedido pedido);
	
	Pedido getById(Long codigo);
}
