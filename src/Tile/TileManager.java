package Tile;

import main.S1;

import javax.imageio.ImageIO;
import java.awt.*;

public class TileManager {
    S1 gp;
    Tile[] tile;

    public TileManager(S1 gp){
        this.gp = gp;
        tile = new Tile[10];
        getIMG();
    }
    public void getIMG(){
        try {
            tile[0] = new Tile();
            tile[0].img = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
            tile[1] = new Tile();
            tile[1].img = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
            tile[2] = new Tile();
            tile[2].img = ImageIO.read(getClass().getResourceAsStream("/tiles/path.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void draw (Graphics2D g2 ){
        g2.drawImage(tile[0].img,0,0,gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].img,70,0,gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[2].img,140,0,gp.tileSize, gp.tileSize, null);

    }
}
