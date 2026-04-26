package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class TitleScreen extends JPanel implements Runnable{
    private JFrame jframe;
    S1 s;

    public TitleScreen() {
       jframe = new JFrame("My first 2D game");
       init();
    }
    public void init(){
        jframe.setSize(800,600);
        jframe.setVisible(true);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLayout(null);


        JButton button = new JButton();
        button.setBounds(280,390,250,95);
        java.net.URL imgURL = getClass().getResource("/Images/pixil-frame-0.png");
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
            S1 s = new S1();   // create it HERE (on click)
            s.startGamethread();
            jframe.dispose();

        });
        jframe.add(button, BorderLayout.CENTER);
        try {
            String path = "/Images/a34c95dc15ad78b97bb6c5fd681f8579.jpg";
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


    @Override
    public void run() {

    }
}

