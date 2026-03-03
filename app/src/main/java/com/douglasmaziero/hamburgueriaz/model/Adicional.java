package com.douglasmaziero.hamburgueriaz.model;

public class Adicional {
    private String nome;
    private double valor;

    public Adicional(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }
    public String getNome() {
        return nome;
    }
    public double getValor() {
        return valor;
    }
}
