package com.gabriel.sistemafinanceiro.resource.v1.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.sistemafinanceiro.resource.v1.PedidoResource;
import com.gabriel.sistemafinanceiro.resource.v1.assembler.PedidoResourceAssembler;
import com.gabriel.sistemafinanceiro.service.PedidoServiceImpl;

@RestController
@RequestMapping("/pedidos")
public class PedidoRestService {

	@Autowired
	private PedidoResourceAssembler pedidoResourceAssembler;
	
	@Autowired
	private PedidoServiceImpl pedidoService;
	
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = "application/json")
	public List<PedidoResource> listAll(){
		
		return this.pedidoResourceAssembler
						.toResource(pedidoService.listAll());
		
	}
		
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value ="/{codigo}" , produces ="application/json")
	public PedidoResource getByCodigo(
			
			@PathVariable("codigo") Long codigo) {
		
		return this.pedidoResourceAssembler
						.toResource(this.pedidoService.getById(codigo));
		
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "", produces ="application/json")
	public PedidoResource save(@RequestBody @Valid PedidoResource pedidoResource) {
		
	System.out.println(pedidoResource.getFornecedor().getDescricao());	
		
	 return	this.pedidoResourceAssembler.toResource(
			 
			 this.pedidoService
			 .save(this.pedidoResourceAssembler
					 .toDomain(pedidoResource)));
		
		
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping(value = "/{codigo}", produces ="application/json")
	public PedidoResource update(
			
			@PathVariable("codigo") Long codigo,
			@RequestBody @Valid PedidoResource pedidoResource) {
		
	 return	this.pedidoResourceAssembler.toResource(
			 
			 this.pedidoService
			 .update(codigo,this.pedidoResourceAssembler
					 .toDomain(pedidoResource)));
		
		
	}
	
}
