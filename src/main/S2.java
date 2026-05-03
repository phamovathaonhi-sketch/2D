package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;

public class S2 extends JPanel {
    JFrame jframe;

    public S2(){
        jframe = new JFrame("S2");
        this.setFocusable(true);
        intit();
    }
    public void intit(){
        jframe.setSize(800,600);
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
        jframe.setLocationRelativeTo(null);
    }
}
