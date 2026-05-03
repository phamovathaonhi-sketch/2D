package main;

import Tile.TileManager;
import gameChar.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class S1 extends JPanel implements Runnable {
    private JFrame jframe;
    private JScrollPane scrollPane;
    Thread gamethread;
    private int origi = 10;
    private int scale= 7;
    public int tileSize = origi*scale;
    //FPS
    int FPS = 60;
    TileManager tileManager = new TileManager(this);
    Keyhandler K = new Keyhandler();
    Player p = new Player(this,K);

    public S1(){
        jframe = new JFrame("S1");
        init();
        this.addKeyListener(K);
        this.setFocusable(true);
    }
    public void init(){
        jframe.setSize(800, 600);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        try {
            String path = "/images/a34c95dc15ad78b97bb6c5fd681f8579.jpg";
            InputStream is = getClass().getResourceAsStream(path);

            if (is != null) {
                jframe.setIconImage(ImageIO.read(is));
            } else {
                System.out.println("Error: Could not find image at " + path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        tileManager.draw(g2);
        p.paint(g2);
        g2.dispose();

    }
}
