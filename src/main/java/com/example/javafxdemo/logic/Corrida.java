package com.example.javafxdemo.logic;

import java.util.List;

public class Corrida {
    private List<Jogador> jogadores;
    private List<IA> ias;
    private Percurso percurso;

    public Corrida(List<Jogador> jogadores, List<IA> ias, Percurso percurso) {
        this.jogadores = jogadores;
        this.ias = ias;
        this.percurso = percurso;
    }

    public void iniciar() {
        // Lógica para iniciar a corrida
    }

    public void atualizar() {
        // Lógica para atualizar o estado da corrida
        for (Jogador jogador : jogadores) {
            // Atualizar estado do jogador
        }
        for (IA ia : ias) {
            ia.atualizar();
        }
    }

    // Getters e Setters

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
}