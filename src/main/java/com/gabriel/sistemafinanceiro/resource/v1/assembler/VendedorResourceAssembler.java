package com.gabriel.sistemafinanceiro.resource.v1.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.gabriel.sistemafinanceiro.model.Vendedor;
import com.gabriel.sistemafinanceiro.resource.v1.VendedorResource;
import com.gabriel.sistemafinanceiro.resource.v1.rest.VendedorRestService;

@Component
public class VendedorResourceAssembler extends ResourceAssemblerSupport<Vendedor, VendedorResource> {
	
		
	public VendedorResourceAssembler() {

		super(VendedorRestService.class, VendedorResource.class);

	}
	
	@Override
	public VendedorResource toResource(Vendedor entity) {
			
		VendedorResource vendedorResource = new VendedorResource();
		
		BeanUtils.copyProperties(entity, vendedorResource);
		
		addLinks(vendedorResource);
		
		return vendedorResource;
		
		
	}
	
	public List<VendedorResource> toResource(List<Vendedor> vendedores){
		
		List<VendedorResource> vendedoresResource = new ArrayList<>();
		
		vendedores.forEach(v -> vendedoresResource.add(toResource(v)));
		
		return vendedoresResource;
		
	}
	
	public Vendedor toDomain(VendedorResource vendedorResource) {
		
		
		
		return Vendedor.builder()
			.codigo(vendedorResource.getCodigo())
			.nome(vendedorResource.getNome())
			.status(vendedorResource.getStatus()).build();
		
		
	}
	
	private void addLinks(VendedorResource vendedorResource) {
		
		vendedorResource.add(new Link("http://localhost:8080"));
		
	}
	

}
