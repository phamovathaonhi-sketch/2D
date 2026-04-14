package gameChar;
import main.Keyhandler;
import main.S1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    S1 gamePanel;
    Keyhandler keyhandler;

    public Player(S1 gamePanel, Keyhandler keyhandler) {
        this.gamePanel = gamePanel;
        this.keyhandler = keyhandler;
        setDefault();
        getImage();
    }
    public void setDefault(){
        x= 100;
        y=100;
        speed = 4;
        direction = "down";
    }
    public void getImage(){
        try {
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/behindpose1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/behindpose2.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/pose1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/pose2.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/poseleft1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/poseleft2.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/poseright1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/poseright2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update(){
        if (keyhandler.upressed == true){
            direction ="up";
             y-=speed;
        } else if (keyhandler.downpressed == true) {
            direction ="down";
            y+=speed;
        } else if (keyhandler.rightpressed == true) {
            direction ="right";
            x += speed;
        } else if (keyhandler.leftpressed == true) {
            direction ="left";
            x -= speed;
        }

    }
    public void paint(Graphics2D g2){
      //  g2.setColor(Color.black);
       // g2.fillRect(x,y,gamePanel.tileSize,gamePanel.tileSize);
        BufferedImage img= null;

        switch (direction){
            case "up":
                img = up1;
                break;
            case "down":
                img = down1;
                break;
            case "left":
                img = left1;
                break;
            case "right":
                img = right1;
                break;

        }
        g2.drawImage(img, x,y, gamePanel.tileSize,gamePanel.tileSize, null);
    }
    }


