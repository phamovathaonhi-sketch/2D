package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class TitleScreen extends JPanel implements Runnable{
    private JFrame jframe;
    public int size1 = 800;
    public int size2= 600;
    private TitleBackground background;
    private Thread gamethread;
    private boolean running = true;

    public TitleScreen() {
       jframe = new JFrame("My first 2D game");
       init();
    }
    public void init(){
        jframe.setSize(size1,size2);
        jframe.setVisible(true);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLayout(null);


        JButton button = new JButton();
        button.setBounds(280,390,250,95);
        java.net.URL imgURL = getClass().getResource("/images/pixil-frame-0.png");
        jframe.add(button, BorderLayout.CENTER);

        if (imgURL != null) {

            ImageIcon buttonIcon = new ImageIcon(imgURL);

            button.setIcon(buttonIcon);
        }


        button.setBorderPainted(true);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        button.addActionListener(e ->{
            Selections s = new Selections();
            running = false;
            jframe.dispose();

        });
        jframe.add(this);
        jframe.add(button, BorderLayout.CENTER);

        background = new TitleBackground();
        startGamethread();
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
    }

    public void startGamethread(){
        gamethread = new Thread(this);
        gamethread.start();
    }
    @Override
    public void run() {
        int FPS = 60;
        long drawint = 1000000000/FPS;
        while (running){
            long start = System.nanoTime();
            repaint();
            long sleep = drawint - (System.nanoTime() - start);
            if (sleep>0){
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }


    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background!= null){
            background.draw(g,getWidth(),getHeight());
        }



    }
}

