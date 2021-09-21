package com.itau.bancoitau.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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

    @Column(name = "TitularDaConta", length = 200, nullable = false)
    private String titularDaConta;

    // Referência para o  objeto do tipo cliente
    @ManyToOne
    @JoinColumn(name = "id_cliente")
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

    public String getTitularDaConta() {
        return titularDaConta;
    }

    public void setTitularDaConta(String titularDaConta) {
        this.titularDaConta = titularDaConta;
    }

   

    
}
