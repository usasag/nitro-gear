package com.example.javafxdemo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.example.javafxdemo.Main;

public class MenuPrincipalController {
    @FXML
    private Button startGameButton;
    @FXML
    private Button helpButton;
    @FXML
    private Button exitButton;


    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void initialize() {
        startGameButton.setOnAction(event -> {
            try {
                mainApp.mostrarEscolhaDeCarros();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        helpButton.setOnAction(event -> {
            try {
                mainApp.mostrarHelp();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        exitButton.setOnAction(event -> {
            System.exit(0);
        });
    }
}