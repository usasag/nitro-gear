package com.example.javafxdemo.logic;

public class Jogador {
    private String nome;
    private Veiculo veiculo;

    public Jogador(String nome, Veiculo veiculo) {
        this.nome = nome;
        this.veiculo = veiculo;
    }

    public void controlarVeiculo(String comando) {
        switch (comando) {
            case "ESQUERDA":
                veiculo.moverParaEsquerda();
                break;
            case "DIREITA":
                veiculo.moverParaDireita();
                break;
            case "AUMENTAR_MARCHA":
                veiculo.aumentarMarcha();
                break;
            case "DIMINUIR_MARCHA":
                veiculo.diminuirMarcha();
                break;
        }
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}