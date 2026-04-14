package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyhandler implements KeyListener {
    public boolean upressed;
    public boolean downpressed;
    public boolean rightpressed;
    public boolean leftpressed;
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_DOWN){
            downpressed= true;
            
        }
        if (code == KeyEvent.VK_UP){
            upressed= true;

        }
        if (code == KeyEvent.VK_RIGHT){
            rightpressed= true;

        }
        if (code == KeyEvent.VK_LEFT){
            leftpressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_DOWN){
            downpressed= false;

        }
        if (code == KeyEvent.VK_UP){
            upressed= false;

        }
        if (code == KeyEvent.VK_RIGHT){
            rightpressed= false;

        }
        if (code == KeyEvent.VK_LEFT){
            leftpressed = false;
        }
    }
}
