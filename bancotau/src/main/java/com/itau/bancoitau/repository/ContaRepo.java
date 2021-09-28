package com.itau.bancoitau.repository;

import com.itau.bancoitau.model.Conta;

import org.springframework.data.repository.CrudRepository;

public interface ContaRepo extends CrudRepository<Conta, Integer> {

    
}
