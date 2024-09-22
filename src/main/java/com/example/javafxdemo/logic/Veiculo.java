package com.example.javafxdemo.logic;

import javafx.scene.image.Image;

public class Veiculo {
    private String nome;
    private Image sprite;
    private double[] velocidadesMaximas; // Array para diferentes marchas
    private double velocidadeAtual;
    private double posicaoX;
    private double posicaoY;
    private int marchaAtual;

    public Veiculo(String nome, Image sprite, double[] velocidadesMaximas) {
        this.nome = nome;
        this.sprite = sprite;
        this.velocidadesMaximas = velocidadesMaximas;
        this.velocidadeAtual = 0;
        this.posicaoX = 0;
        this.posicaoY = 0;
        this.marchaAtual = 0; // Inicia na primeira marcha
    }

    public void aumentarMarcha() {
        if (marchaAtual < velocidadesMaximas.length - 1) {
            marchaAtual++;
        }
    }

    public void diminuirMarcha() {
        if (marchaAtual > 0) {
            marchaAtual--;
        }
    }

    public void moverParaEsquerda() {
        posicaoX -= 5; // Ajustar conforme necessário
    }

    public void moverParaDireita() {
        posicaoX += 5; // Ajustar conforme necessário
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    public double[] getVelocidadesMaximas() {
        return velocidadesMaximas;
    }

    public void setVelocidadesMaximas(double[] velocidadesMaximas) {
        this.velocidadesMaximas = velocidadesMaximas;
    }

    public double getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(double velocidadeAtual) {
        this.velocidadeAtual = velocidadeAtual;
    }

    public double getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(double posicaoX) {
        this.posicaoX = posicaoX;
    }

    public double getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(double posicaoY) {
        this.posicaoY = posicaoY;
    }

    public int getMarchaAtual() {
        return marchaAtual;
    }

    public void setMarchaAtual(int marchaAtual) {
        this.marchaAtual = marchaAtual;
    }
}