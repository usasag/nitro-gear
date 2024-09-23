package com.example.javafxdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.example.javafxdemo.controllers.*;
import com.example.javafxdemo.logic.*;

public class Main extends Application {
    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        mostrarMenuPrincipal();
    }

    public void mostrarMenuPrincipal() throws Exception {
    System.out.println("Inicio da funcao");
    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-menu.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 1280, 800);
    stage.setTitle("Nitro Gear - Menu Principal");
    stage.setScene(scene);
    // Controlador do menu principal
    MenuPrincipalController controller = fxmlLoader.getController();
    controller.setMainApp(this);

    stage.show();
}

    public void mostrarHelp() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("help.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 800);
        stage.setTitle("Nitro Gear - Ajuda");
        stage.setScene(scene);

        // Controlador da ajuda
        HelpController controller = fxmlLoader.getController();
        controller.setMainApp(this);
        
        stage.show();
    }

    public void mostrarEscolhaDeCarros() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("selector.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 800);
        stage.setTitle("Nitro Gear - Escolha de Carros");
        stage.setScene(scene);
        // Controlador da escolha de carros
        EscolhaCarrosController controller = fxmlLoader.getController();
        controller.setMainApp(this);

        stage.show();
    }

    public void voltar() throws Exception {
        
        mostrarMenuPrincipal();
    }

    public static void main(String[] args) {
        launch();
    }
}