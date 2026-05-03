package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Selections extends JPanel implements Runnable {

    private JFrame jframe;
    private Thread gameThread;
    private boolean running = true;

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public Selections() {
        jframe = new JFrame("Selections");
        init();
    }

    private void init() {

        jframe.setSize(WIDTH, HEIGHT);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        this.setLayout(null);
        this.setBounds(0, 0, WIDTH, HEIGHT);
        jframe.add(this);

        try {
            InputStream is = getClass().getResourceAsStream(
                    "/Images/a34c95dc15ad78b97bb6c5fd681f8579.jpg");
            if (is != null) {
                jframe.setIconImage(ImageIO.read(is));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JButton bu1 = createCakeButton(170, 280);
        bu1.addActionListener(e -> {
            S1 s1 = new S1();
            s1.startGamethread();
            running = false;
            jframe.dispose();
        });

        JButton bu2 = createSashimiButton(460, 350);
        bu2.addActionListener(e -> {
            new S2();
            running = false;
            jframe.dispose();
        });

        this.add(bu1);
        this.add(bu2);

        startGameThread();
        jframe.setVisible(true);
    }

    private JButton createCakeButton(int x, int y) {
        JButton button = new JButton();
        button.setBounds(x, y, 180, 180);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);

        URL imgURL = getClass().getResource("/images/cake.png");
        if (imgURL != null) {
            ImageIcon temp = new ImageIcon(imgURL);
            Image scaled = temp.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(scaled));
        }
        return button;
    }
    private JButton createSashimiButton(int x, int y){
        JButton bu2 = new JButton();
        bu2.setBounds(x,y,100,100);
        bu2.setBorderPainted(false);
        bu2.setContentAreaFilled(false);
        bu2.setFocusPainted(false);
        bu2.setOpaque(false);
        URL imgURL = getClass().getResource("/images/sashimi.png");
        if (imgURL != null) {
            ImageIcon temp = new ImageIcon(imgURL);
            Image scaled = temp.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
            bu2.setIcon(new ImageIcon(scaled));
        }
        return bu2;
    }

    private void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        final int FPS = 60;
        final long drawInterval = 1000000000 / FPS;

        while (running) {
            long start = System.nanoTime();
            repaint();

            long sleep = drawInterval - (System.nanoTime() - start);
            if (sleep > 0) {
                try {
                    Thread.sleep(sleep / 1000000);
                } catch (InterruptedException ignored) {
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(245, 210, 225));
        g.fillRect(0, 0, getWidth(), getHeight());

    }
}