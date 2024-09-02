package com.example.javafxdemo.logic;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controles {
    private Jogador jogador;

    public Controles(Jogador jogador, Scene scene) {
        this.jogador = jogador;
        scene.setOnKeyPressed(this::handleKeyPress);
    }

    private void handleKeyPress(KeyEvent event) {
        KeyCode keyCode = event.getCode();
        switch (keyCode) {
            case W:
                jogador.controlarVeiculo("ACELERAR");
                break;
            case S:
                jogador.controlarVeiculo("FREAR");
                break;
            case A:
                jogador.controlarVeiculo("ESQUERDA");
                break;
            case D:
                jogador.controlarVeiculo("DIREITA");
                break;
            case Q:
                jogador.controlarVeiculo("DIMINUIR_MARCHA");
                break;
            case E:
                jogador.controlarVeiculo("AUMENTAR_MARCHA");
                break;
            default:
                break;
        }
    }
}