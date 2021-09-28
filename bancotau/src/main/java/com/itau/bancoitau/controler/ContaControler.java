package com.itau.bancoitau.controler;

import java.util.List;

import com.itau.bancoitau.model.Conta;
import com.itau.bancoitau.repository.ContaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Indica que a classe é um Controler Rest
@RequestMapping("/conta") //Toda vez que chegar com a requisição desse tipo (/user) ele aciona public class ContaControler
@CrossOrigin("*") // Liberando para acessos de diferentes origens
public class ContaControler {
    
    @Autowired //Pede para implementar a classe e os métodos de acesso
    public ContaRepo repo;

    @GetMapping("/all")
    public List<Conta> obterTodas(){
        return (List<Conta>) repo.findAll(); // Casting  pega uma lista de objetos e devolve uma lista de contas
    }

    @GetMapping("/id/{codigo}")
    public ResponseEntity<Conta> ObterConta(@PathVariable Integer codigo){
    Conta contaEncontrada = repo.findById(codigo).orElse(null);

        if(contaEncontrada != null){
            return ResponseEntity.ok(contaEncontrada); // retona 200 - ok
        }else {
            return ResponseEntity.notFound().build(); // resposta vazia com 404
        }

    }
}
