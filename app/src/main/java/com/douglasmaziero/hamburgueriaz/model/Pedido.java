package com.douglasmaziero.hamburgueriaz.model;

import java.util.ArrayList;
import java.util.List;
public class Pedido {
    private String nomeCliente;
    private int quantidade;
    private double valorBase = 20;
    private double valorTotal;
    private List<Adicional> adicionais = new ArrayList<>();
public double calculaAdicionais(){
    double valorAdicionais = 0;
    for(Adicional adicional : adicionais){
        valorAdicionais += adicional.getValor();
    }
    return valorAdicionais;
}

public double calculaTotal(){
    valorTotal = (valorBase + calculaAdicionais()) * quantidade;

    return valorTotal;
}

public int adicionarLanche(){
    quantidade++;
    return quantidade;
}

public int tirarLanche(){
    if(quantidade == 0){
        return 0;
    }
    quantidade--;
    return quantidade;
}

public void adicionarAdicional(Adicional adicional){
    adicionais.add(adicional);
}

public void removerAdicional(Adicional adicional){
    adicionais.remove(adicional);
}

public int getQuantidade(){
    return quantidade;
}

public void setNomeCliente(String nomeCliente){
    this.nomeCliente = nomeCliente;
}

public String getNomeCliente(){
    return nomeCliente;
}

public boolean finalizarPedido(){
    if(quantidade == 0){
        return false;
    }

    return true;
}

}
