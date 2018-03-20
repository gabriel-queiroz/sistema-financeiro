package com.gabriel.sistemafinanceiro.resource.v1.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.gabriel.sistemafinanceiro.model.Fornecedor;
import com.gabriel.sistemafinanceiro.resource.v1.FornecedorResource;
import com.gabriel.sistemafinanceiro.resource.v1.rest.FornecedorRestService;

@Component
public class FornecedorResourceAssembler extends ResourceAssemblerSupport<Fornecedor, FornecedorResource> {


	public FornecedorResourceAssembler() {
		super(FornecedorRestService.class, FornecedorResource.class);
	}

	@Override
	public FornecedorResource toResource(Fornecedor fornecedor) {

		FornecedorResource resource = new FornecedorResource();

		BeanUtils.copyProperties(fornecedor, resource);

		addLinks(resource);
		return resource;


	}

	public List<FornecedorResource> toResource(List<Fornecedor> fornecedores){

		List<FornecedorResource> fornecedorResources = new ArrayList<>();

		fornecedores.forEach(f -> fornecedorResources.add(toResource(f)));

		return fornecedorResources;



	}


	public Fornecedor toDomain(FornecedorResource fornecedorResource) {

		return Fornecedor.builder()

				.descricao(fornecedorResource.getDescricao())
				.categoria(fornecedorResource.getCategoria())
				.margemLucro(fornecedorResource.getMargemLucro()).build();

	}

	private void addLinks(FornecedorResource fornecedorResource) {



		fornecedorResource.add(new Link("http://localhost:8080/fornecedor/"+fornecedorResource.getCodigo(),"self"));
		

	}


}
