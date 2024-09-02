package com.example.javafxdemo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.example.javafxdemo.Main;
import com.example.javafxdemo.logic.Veiculo;

public class EscolhaCarrosController {
    @FXML
    private ImageView carroPreview;
    @FXML
    private Button comecarCorridaBtn;
    @FXML
    private Button blackOutBtn;
    @FXML
    private Button blueStripBtn;
    @FXML
    private Button greenRocketBtn;
    @FXML
    private Button pinkBulletBtn;
    @FXML
    private Button redRunnerBtn;
    @FXML
    private Button whiteSnakeBtn;

    private Main mainApp;
    private Veiculo veiculoEscolhido;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void initialize() {
        blackOutBtn.setOnAction(event -> selecionarCarro("BlackOut"));
        blueStripBtn.setOnAction(event -> selecionarCarro("BlueStrip"));
        greenRocketBtn.setOnAction(event -> selecionarCarro("GreenRocket"));
        pinkBulletBtn.setOnAction(event -> selecionarCarro("PinkBullet"));
        redRunnerBtn.setOnAction(event -> selecionarCarro("RedRunner"));
        whiteSnakeBtn.setOnAction(event -> selecionarCarro("WhiteSnake"));

        comecarCorridaBtn.setOnAction(event -> {
            try {
                mainApp.iniciarCorrida(veiculoEscolhido);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        comecarCorridaBtn.setDisable(true);
    }

    private void selecionarCarro(String nomeCarro) {
        Image sprite = new Image("./carsprites/" + nomeCarro + ".png");
        carroPreview.setImage(sprite);

        double[] velocidadesMaximas = {50, 100, 150}; // Exemplo de velocidades para 3 marchas
        veiculoEscolhido = new Veiculo(nomeCarro, sprite, velocidadesMaximas, 5);

        comecarCorridaBtn.setDisable(false);
    }
}