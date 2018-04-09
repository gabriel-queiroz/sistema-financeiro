package com.gabriel.sistemafinanceiro.resource.v1.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.sistemafinanceiro.model.Status;
import com.gabriel.sistemafinanceiro.resource.v1.VendedorResource;
import com.gabriel.sistemafinanceiro.resource.v1.assembler.VendedorResourceAssembler;
import com.gabriel.sistemafinanceiro.service.VendedorServiceImpl;

@RestController
@RequestMapping("vendedores")
public class VendedorRestService {

	@Autowired
	private VendedorResourceAssembler vendedorResourceAssembler;

	@Autowired
	private VendedorServiceImpl vendedorService;


	@ResponseStatus(HttpStatus.OK)
	@GetMapping()
	public List<VendedorResource> listAll(){

		return vendedorResourceAssembler
				.toResource(vendedorService.listAll());

	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{codigo}")
	public VendedorResource getByCodigo( 

			@PathVariable("codigo") @Valid Long codigo) {

		return vendedorResourceAssembler.toResource(

				vendedorService.getByCodigo(codigo));


	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public VendedorResource save(
			
			@RequestBody VendedorResource vendedorResource) {

		return vendedorResourceAssembler.toResource(

				vendedorService
				.save(vendedorResourceAssembler
						.toDomain(vendedorResource)));

	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{codigo}")
	public VendedorResource update(
			
			@PathVariable("codigo") Long codigo,
			@RequestBody VendedorResource vendedorResource) {

		return vendedorResourceAssembler.toResource(
				vendedorService.update(
						codigo, vendedorResourceAssembler
						.toDomain(vendedorResource)));	

	}

	@ResponseStatus(HttpStatus.OK)
	@PatchMapping("/{codigo}")
	public void updateStatus(

			@PathVariable("codigo") Long codigo,
			@RequestBody Status status) {

		vendedorService.updateStatus(codigo, status);

	}
}


