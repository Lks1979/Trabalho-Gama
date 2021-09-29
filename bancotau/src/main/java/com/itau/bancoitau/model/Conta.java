package com.itau.bancoitau.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity //Esta classe será mapeada no banco de dados
@Table(name = "tb_contas")
public class Conta {

    @Id //Esse atributo é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto incremento
    private int id;    
    
    @Column(name = "numero", nullable = false, unique = true)
    private long numero;

    @Column(name = "agencia", nullable = false)
    private long agencia;

    @Column(name = "tipoDeConta", nullable = false)
    private int tipoDeConta;

    @Column(name = "saldo", nullable = false)
    private long saldo;    

    // Referência para o  objeto do tipo cliente
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonIgnoreProperties("contas")
    private Cliente proprietario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public long getAgencia() {
        return agencia;
    }

    public void setAgencia(long agencia) {
        this.agencia = agencia;
    }

    public int getTipoDeConta() {
        return tipoDeConta;
    }

    public void setTipoDeConta(int tipoDeConta) {
        this.tipoDeConta = tipoDeConta;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }
   
    public Cliente getProprietario() {
        return proprietario;
    }

    public void setProprietario(Cliente proprietario) {
        this.proprietario = proprietario;
    }  

    
}
