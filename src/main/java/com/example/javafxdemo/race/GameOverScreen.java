package com.example.javafxdemo.race;

import com.example.javafxdemo.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverScreen extends JFrame {
    private Main mainApp;

    public GameOverScreen(Main mainApp) {
        this.mainApp = mainApp;
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel messageLabel = new JLabel("Fim da Corrida! Você completou 3 voltas.", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JButton exitButton = new JButton("Sair");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(exitButton);

        setLayout(new BorderLayout());
        add(messageLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameOverScreen(new Main()).setVisible(true);
            }
        });
    }

    public void mostrarGameOverScreen() {
        SwingUtilities.invokeLater(() -> {
            new GameOverScreen(mainApp).setVisible(true);
            dispose();
        });
    }
}