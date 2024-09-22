package com.example.javafxdemo.race;

import com.example.javafxdemo.logic.Veiculo;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class RacePlay extends JFrame {
    private static final int D_W = 1500;
    private static final int D_H = 1200;
    private int with = 1600;
    private int height = 768;
    private int roadW = 768;
    private int segL = 768;
    private double camD = 0.84;
    private int N;
    private int playerX = 0;
    private int pos = 0;
    private int lapCount = 0;
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean leftPressed = false;
    private boolean rightPressed = false;
    private double velocidade = 0;
    private double aceleracao = 20;
    private double desaceleracao = 1;
    private double frenagem = 5;
    private double velocidadeMaxima = 500;
    private List<Line> lines = new ArrayList<>();
    private DrawPanel drawPanel;

    public RacePlay(Veiculo veiculoEscolhido) {
        drawPanel = new DrawPanel(veiculoEscolhido); // Passando veículo escolhido para o painel de desenho
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                        upPressed = true;
                        break;
                    case KeyEvent.VK_S:
                        downPressed = true;
                        break;
                    case KeyEvent.VK_A:
                        leftPressed = true;
                        break;
                    case KeyEvent.VK_D:
                        rightPressed = true;
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                        upPressed = false;
                        break;
                    case KeyEvent.VK_S:
                        downPressed = false;
                        break;
                    case KeyEvent.VK_A:
                        leftPressed = false;
                        break;
                    case KeyEvent.VK_D:
                        rightPressed = false;
                        break;
                }
            }
        });

        for (int i = 0; i < 1600; i++) {
            Line line = new Line();
            line.z = i * segL;
            if (i > 200 && i < 700) {
                line.curve = 4;
            }
            if (i > 1000) {
                line.y = Math.sin(Math.toRadians(i / 30)) * 1500;
                if (line.y < 0) {
                    line.y = 0;
                }
            }
            if (i % 2 == 0) {
                line.spriteX = -2.5;
                line.drawTree = true;
                System.out.println("drawTree " + i);
            }
            lines.add(line);
        }
        N = lines.size();

        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCarPosition();
                drawPanel.repaint();
            }
        });
        timer.start();

        add(drawPanel);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateCarPosition() {
        if (upPressed) {
            if (velocidade < velocidadeMaxima) {
                velocidade += aceleracao;
            }
        } else {
            if (velocidade > 0) {
                velocidade -= desaceleracao;
            }
        }

        if (downPressed) {
            if (velocidade > 0) {
                velocidade -= frenagem;
                if (velocidade < 0) {
                    velocidade = 0;
                }
            }
        }

        if (leftPressed) {
            playerX -= 20;
        }
        if (rightPressed) {
            playerX += 20;
        }

        if (pos >= N * segL) {
            pos = 0;
            lapCount++;
        }

        pos += velocidade;
    }

    private class DrawPanel extends JPanel {
        private Image carImage;

        public DrawPanel(Veiculo veiculoEscolhido) {
            // Carregar imagem do carro usando o nome do veículo
            try {
                carImage = ImageIO.read(getClass().getResourceAsStream("/carsprites/" + veiculoEscolhido.getNome() + "Ingame.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawValues(g);

            g.setColor(Color.WHITE); // Cor do texto
            g.setFont(new Font("Arial", Font.BOLD, 24)); // Fonte e tamanho do texto
            g.drawString("Voltas: " + lapCount + "/3", 20, 40); // Posição e texto

            // Desenhar a imagem do carro
            if (carImage != null) {
                int x = (getWidth() - carImage.getWidth(this)) / 2;
                int y = getHeight() - carImage.getHeight(this);
                g.drawImage(carImage, x, y, this);
            }
        }

        private void drawValues(Graphics g) {
            int startPos = pos / segL;
            double x = 0, dx = 0;
            double maxY = height;
            int camH = 1500 + (int) lines.get(startPos).y;
            for (int n = startPos; n < startPos + 300; n++) {
                Line l = lines.get(n % N);
                l.project(playerX - (int) x, camH, pos);
                x += dx;
                dx += l.curve;
                if (l.Y > 0 && l.Y < maxY) {
                    maxY = l.Y;
                    Color grass = ((n / 2) % 2) == 0 ? new Color(16, 200, 16) : new Color(0, 154, 0);
                    Color rumble = ((n / 2) % 2) == 0 ? new Color(255, 255, 255) : new Color(255, 0, 0);
                    Color road = Color.black;
                    Color midel = ((n / 2) % 2) == 0 ? new Color(255, 255, 255) : new Color(0, 0, 0);

                    Line p = (n == 0) ? l : lines.get((n - 1) % N);

                    drawQwad(g, grass, 0, (int) p.Y, with, 0, (int) l.Y, with);
                    drawQwad(g, rumble, (int) p.X, (int) p.Y, (int) (p.W * 1.5), (int) l.X, (int) l.Y,
                            (int) (l.W * 1.5));
                    drawQwad(g, road, (int) p.X, (int) p.Y, (int) (p.W * 1.4), (int) l.X, (int) l.Y,
                            (int) (l.W * 1.4));
                    drawQwad(g, midel, (int) p.X, (int) p.Y, (int) (p.W * 0.8), (int) l.X, (int) l.Y,
                            (int) (l.W * 0.8));
                    drawQwad(g, road, (int) p.X, (int) p.Y, (int) (p.W * 0.7), (int) l.X, (int) l.Y, (int) (l.W * 0.7));
                }
            }
            // draw Skye
            Graphics g9d = g;
            g9d.setColor(Color.blue);
            g9d.fillRect(0, 0, 1600, 387);
            try {
                g9d.drawImage(
                        ImageIO.read(new File(
                                "C:/Users/HP/Desktop/paintr/tangarfa/workspace/java-tmz-test/ressource/cropped-sky-web-background.jpg")),
                        0, 0, this);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // draw tree
            for (int n = startPos + 300; n > startPos; n--) {
                if (lines.get(n % N).drawTree) {
                    lines.get(n % N).drawGraphic();
                    Graphics gd = g;
                }
            }
        }

        void drawQwad(Graphics g, Color c, int x1, int y1, int w1, int x2, int y2, int w2) {
            Graphics g9d = g;
            int[] x9Points = { x1 - w1, x2 - w2, x2 + w2, x1 + w1 };
            int[] y9Points = { y1, y2, y2, y1 };
            int n9Points = 4;
            g9d.setColor(c);
            g9d.fillPolygon(x9Points, y9Points, n9Points);
        }

        public Dimension getPreferredSize() {
            return new Dimension(D_W, D_H);
        }
    }

    public static void main(Veiculo veiculoEscolhido) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                new RacePlay(veiculoEscolhido);
            }
        });
    }

    class Line {
        double x, y, z;
        double X, Y, W;
        double scale, curve, spriteX, clip;
        Graphics graphic;
        double destX;
        double destY;
        double destW;
        double destH;
        boolean drawTree = false;

        public Line() {
            curve = x = y = z = 0;
        }

        void project(int camX, int camY, int camZ) {
            scale = camD / (z - camZ);
            X = (1 + scale * (x - camX)) * with / 2;
            Y = (1 - scale * (y - camY)) * height / 2;
            W = scale * roadW * with / 2;
        }

        void drawGraphic() {
            int W = 100;
            int h = 100;
            destX = X + scale * spriteX * with / 2;
            destY = Y + 4;
            destW = W * W / 266;
            destH = h * W / 266;
            destX += destW * spriteX;
            destY += destH * (-1);
            double clipH = destY + destH - clip;
            if (clipH < 0)
                clipH = 0;
            if (clipH > destH)
                drawTree = false;
        }
    }
}