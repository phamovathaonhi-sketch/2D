import javax.swing.*;
import java.awt.*;

public class S1 extends JPanel implements Runnable {
    private JFrame jframe;
    private JScrollPane scrollPane;
    Thread gamethread;

    public S1(){
        jframe = new JFrame("Menu");
        init();
    }
    public void init(){
        jframe.setSize(800,600);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jframe.setLayout(new BorderLayout());
        this.setDoubleBuffered(true);

    }
    public void startGamethread(){
        gamethread= new Thread(this);
        gamethread.start();
    }

    @Override
    public void run() {
        while(gamethread !=null){

            update();
            repaint();
        }
    }
    public void update(){

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
