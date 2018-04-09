package com.gabriel.sistemafinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.sistemafinanceiro.model.Cliente;

@Repository
public interface ClienteRepository  extends  JpaRepository<Cliente, Long> {

}