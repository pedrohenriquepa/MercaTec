package com.example.mercatec2;

public class produto {
    private  String nome;
    private int quantidade;
    private  int estquantidade;

    public produto(String nome, int quantidade, int i) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.estquantidade = estquantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getEstquantidade() {
        return estquantidade;
    }

    public void setEstquantidade(int estquantidade) {
        this.estquantidade = estquantidade;
    }
    @Override
    public String toString(){
        return nome +" temos aproximadamente "+ quantidade + " para venda." ;
    }
}


