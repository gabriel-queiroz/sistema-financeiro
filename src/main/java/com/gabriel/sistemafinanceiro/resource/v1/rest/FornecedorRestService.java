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
import com.gabriel.sistemafinanceiro.resource.v1.FornecedorResource;
import com.gabriel.sistemafinanceiro.resource.v1.assembler.FornecedorResourceAssembler;
import com.gabriel.sistemafinanceiro.service.FornecedorService;

@RestController
@RequestMapping("fornecedores")
public class FornecedorRestService {

	@Autowired
	private FornecedorService fornecedorService;

	@Autowired
	private FornecedorResourceAssembler fornecedorResourceAssembler;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping()
	public List<FornecedorResource> listAll(){


		return fornecedorResourceAssembler
				.toResource(this.fornecedorService.listAll());

	}



	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public FornecedorResource getById( 
			@PathVariable("id") Long id) {

		return this.fornecedorResourceAssembler.toResource(

				this.fornecedorService.getById(id));

	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/teste/{id}")
	public Status getByIdStatus( 
			@PathVariable("id") Long id) {

		

		return this.fornecedorService.getById(id).getStatus();

	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public FornecedorResource save(

			@RequestBody @Valid FornecedorResource fornecedorResource) {

		return this.fornecedorResourceAssembler.toResource(

				this.fornecedorService
				.save(this.fornecedorResourceAssembler
						.toDomain(fornecedorResource))
				);

	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{codigo}")
	public FornecedorResource update(
			@PathVariable("codigo")  Long codigo,
			@RequestBody @Valid FornecedorResource fornecedorResource) {

		return this.fornecedorResourceAssembler.toResource(

				this.fornecedorService
				.update(codigo,this.fornecedorResourceAssembler
						.toDomain(fornecedorResource))

				);

	}

	@ResponseStatus(HttpStatus.OK)
	@PatchMapping("/{codigo}")
	public void updateStatus(

			@PathVariable("codigo") Long codigo,
			@RequestBody Status status) {

		this.fornecedorService.statusUpdate(codigo, status);
		

	}


}
