package com.example.javafxdemo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.example.javafxdemo.Main;
public class HelpController {
    
    @FXML
    private Button voltarBtn;

    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void initialize() {
        voltarBtn.setOnAction(event -> {
            try {
                mainApp.mostrarMenuPrincipal();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
