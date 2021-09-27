package com.itau.bancoitau.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity //Esta classe será mapeada no banco de dados
@Table(name = "tb_cliente")
public class Cliente {

    @Id //Esse atributo é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto incremento
    private long CodInterno;

    @Column(name = "nome", length = 200, nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true)
    private long cpf;

    @Column(name = "telefone", length = 30, nullable = false)
    private String telefone;

    @Column(name = "email", length = 200, nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "proprietario")
    private List<Conta> contas;

    //Métodos get e set
    public long getCodInterno() {
        return CodInterno;
    }

    public void setCodInterno(long CodInterno) {
        this.CodInterno = CodInterno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    
    

}
