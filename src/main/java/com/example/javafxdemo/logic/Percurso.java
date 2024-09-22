package com.example.javafxdemo.logic;

import javafx.scene.image.Image;

public class Percurso {
    private String nome;
    private Image mapa;

    public Percurso(String nome, Image mapa) {
        this.nome = nome;
        this.mapa = mapa;
    }

    public Percurso(Image mapa) {
        this.nome = "Percurso";
        this.mapa = mapa;
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Image getMapa() {
        return mapa;
    }

    public void setMapa(Image mapa) {
        this.mapa = mapa;
    }
}