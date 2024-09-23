package com.example.javafxdemo.logic;

public class IA {
    private Veiculo veiculo;

    public IA(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void atualizar() {
        // Lógica de IA para controlar o veículo
        veiculo.acelerar();
    }

    // Getters e Setters

    public Veiculo getVeiculo() {
        return veiculo;
    }
}