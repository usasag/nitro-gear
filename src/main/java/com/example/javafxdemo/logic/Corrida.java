package com.example.javafxdemo.logic;

import java.util.ArrayList;
import java.util.List;

public class Corrida {
    private List<Jogador> jogadores;
    private List<IA> ias;
    private Percurso percurso;
    private String[] nomesPossiveisIAs = {"Super Xandão", "Gordin Jaguatirica", "Mamão Verde", "Borracha", "Rodrigo Goes", "Goku SSJ3", "Naruto"};

    public Corrida(List<Jogador> jogadores, List<IA> ias, Percurso percurso) {
        this.jogadores = jogadores;
        this.ias = ias;
        this.percurso = percurso;
        inicializarIAs();
    }

    private void inicializarIAs() {
        for (int i = 0; i < 7; i++) {
            Veiculo veiculoIA = new Veiculo(nomesPossiveisIAs[i], null, new double[]{100, 200, 300, 400, 500});
            IA ia = new IA(veiculoIA);
            ias.add(ia);
        }
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