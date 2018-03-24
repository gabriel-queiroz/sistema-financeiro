package com.gabriel.sistemafinanceiro.resource.v1.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.gabriel.sistemafinanceiro.model.Pedido;
import com.gabriel.sistemafinanceiro.resource.v1.PedidoResource;
import com.gabriel.sistemafinanceiro.resource.v1.rest.PedidoRestService;

@Component
public class PedidoResourceAssembler extends ResourceAssemblerSupport<Pedido,PedidoResource> {

	@Autowired
	private FornecedorResourceAssembler assembler;

	public PedidoResourceAssembler() {

		super(PedidoRestService.class,PedidoResource.class);

	}

	@Override
	public PedidoResource toResource(Pedido entity) {

		PedidoResource pedido = new  PedidoResource();

		BeanUtils.copyProperties(entity, pedido);

		pedido.setFornecedor(this.assembler.toResource(entity.getFornecedor()));
		
		return pedido;
	}
	
	public List<PedidoResource> toResource(List<Pedido> entitys){
		
		List<PedidoResource> pedidosResource = new ArrayList<>();
		
		entitys.forEach(p -> pedidosResource.add(toResource(p)));
		
		return pedidosResource;
	}
	
	public Pedido toDomain(PedidoResource pedidoResource) {
		
		return Pedido.builder()
				.codigo(pedidoResource.getCodigo())
				.dataChegada(pedidoResource.getDataChegada())
				.estado(pedidoResource.getEstado())
				.dataPagemento(pedidoResource.getDataPagemento())
				.dataEnvio(pedidoResource.getDataEnvio())
				.fornecedor(this.assembler.toDomain(pedidoResource.getFornecedor()))
				.build();
		
	}

}