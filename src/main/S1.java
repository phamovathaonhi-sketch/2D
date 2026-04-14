package main;

import gameChar.Player;

import javax.swing.*;
import java.awt.*;

public class S1 extends JPanel implements Runnable {
    private JFrame jframe;
    private JScrollPane scrollPane;
    Thread gamethread;
    private int origi =10;
    private int scale= 5;
    public int tileSize = origi*scale;
    //FPS
    int FPS = 60;
    Keyhandler K = new Keyhandler();
    Player p = new Player(this,K);

    // player default position
    int playerX= 100;
    int playerY = 100;
    int playerSpeed = 4;

    public S1(){
        jframe = new JFrame("Menu");
        init();
        this.addKeyListener(K);
        this.setFocusable(true);
    }
    public void init(){
        jframe.setSize(800, 600);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(this);
        jframe.setVisible(true);
        this.setDoubleBuffered(true);
    }
    public void startGamethread(){
        gamethread= new Thread(this);
        gamethread.start();
    }

    @Override
    public void run() {
        double drawinterval = 1000000000/FPS;
        double nextdrawtime = System.nanoTime() + drawinterval;
        while(gamethread !=null){

            update();
            repaint();
            try {
                double remaining = nextdrawtime - System.nanoTime();
                remaining= remaining/1000000;
                if (remaining < 0){
                    remaining = 0;
                }
                gamethread.sleep((long) remaining);

                nextdrawtime += drawinterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void update(){
      p.update();

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        p.paint(g2);
        g2.dispose();

    }
}
