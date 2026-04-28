package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class StartGamePic {

    private BufferedImage startImage1;
    private BufferedImage startImage2;
    private int startCount = 0;
    private final int switchRate = 60;

    public StartGamePic() {
        loadImages();
    }

    private void loadImages() {
        try {
            startImage1 = ImageIO.read(getClass().getResourceAsStream("/backgrounds/bacground2(1).png"));
            startImage2 = ImageIO.read(getClass().getResourceAsStream("/backgrounds/background1(1).png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        startCount++;

        if (startCount >= switchRate * 2) {
            startCount = 0;
        }

        if (startCount < switchRate) {
            g2.drawImage(startImage1, 0, 0,800 , 600, null);
        } else {
            g2.drawImage(startImage2, 0, 0, 800, 600, null);
        }
    }

}
