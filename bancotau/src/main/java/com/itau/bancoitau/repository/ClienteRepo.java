package com.itau.bancoitau.repository;

import com.itau.bancoitau.model.Cliente;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepo extends CrudRepository<Cliente, Long> {

    
}
