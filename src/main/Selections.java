package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Selections extends JPanel {
    private JFrame jframe;
    Thread gameThread;


    public Selections(){
        jframe = new JFrame("Selections");
        init();
    }
    public void init(){
        jframe.setSize(800,600);
        jframe.setVisible(true);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLayout(null);
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
        JButton bu = new JButton();
        bu.setBounds(250,390,100,100);
        URL imgURL = getClass().getResource("/Images/cake.png");
        if (imgURL != null) {

            ImageIcon buttonIcon = new ImageIcon(imgURL);

            bu.setIcon(buttonIcon);
        }
        bu.setBorderPainted(true);
        bu.setContentAreaFilled(false);
        bu.setFocusPainted(false);
        bu.setOpaque(false);
        bu.addActionListener(e ->{
            S1 s = new S1();
            s.startGamethread();
            jframe.dispose();
        });
        jframe.add(bu);

    }
}
