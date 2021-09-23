package com.itau.bancoitau.controler;

import java.util.List;

import com.itau.bancoitau.model.Cliente;
import com.itau.bancoitau.repository.ClienteRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController //Indica que a classe é um Controler Rest
@RequestMapping("/user") //Toda vez que chegar com a requisição desse tipo (/user) ele aciona public class ClienteControler
@CrossOrigin("*") // Liberando para acessos de diferentes origens
public class ClienteControler {
    
    @Autowired //Pede para implementar a classe e os métodos de acesso
    public ClienteRepo repo;

    @GetMapping("/all")
    public List<Cliente> obterTodos(){
        return (List<Cliente>) repo.findAll(); // Casting  pega uma lista de objetos e devolve uma lista de clientes
    }

    @GetMapping("/id/{codigo}")
    public ResponseEntity<Cliente> ObterCliente(@PathVariable long codigo){
    Cliente clienteEncontrado = repo.findById(codigo).orElse(null);

        if(clienteEncontrado != null){
            return ResponseEntity.ok(clienteEncontrado); // retona 200 - ok
        }else {
            return ResponseEntity.notFound().build(); // resposta vazia com 404
        }

    }
}
