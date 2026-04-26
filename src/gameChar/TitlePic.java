package gameChar;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TitlePic {
    private BufferedImage img1;
    private BufferedImage img2;
    private int rate = 0;
    private int switchRate = 60;

    public TitlePic() {
        loadImage();
    }
    public void loadImage(){
        try {
            img1 = ImageIO.read(getClass().getResourceAsStream(""));
            img2 = ImageIO.read(getClass().getResourceAsStream(""));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
