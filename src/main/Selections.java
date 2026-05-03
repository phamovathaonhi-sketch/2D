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
        bu.setBounds(180,280,180,180);
        URL imgURL = getClass().getResource("/Images/cake.png");

        if (imgURL != null) {
            ImageIcon tempIcon = new ImageIcon(imgURL);


            Image scaledImage = tempIcon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);


            ImageIcon buttonIcon = new ImageIcon(scaledImage);

            bu.setIcon(buttonIcon);
        }
        bu.setBorderPainted(false);
        bu.setContentAreaFilled(false);
        bu.setFocusPainted(false);
        bu.setOpaque(false);
        bu.addActionListener(e ->{
            S1 s = new S1();
            s.startGamethread();
            jframe.dispose();
        });
        JButton bu1 = new JButton();
        bu.setBounds(180,280,180,180);
        URL imgURL1 = getClass().getResource("/Images/cake.png");

        if (imgURL1 != null) {
            ImageIcon tempIcon = new ImageIcon(imgURL1);


            Image scaledImage = tempIcon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);


            ImageIcon buttonIcon = new ImageIcon(scaledImage);

            bu1.setIcon(buttonIcon);
        }
        bu1.setBorderPainted(false);
        bu1.setContentAreaFilled(false);
        bu1.setFocusPainted(false);
        bu1.setOpaque(false);
        bu1.addActionListener(e ->{
            S2 s2 = new S2();
            jframe.dispose();
        });
        jframe.add(bu);
        jframe.add(bu1);

    }
}
