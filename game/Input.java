package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Input implements ActionListener {
    Timer time = new Timer(5, this);
    int x = 0, y = 0, velX = 0, velY = 0;
    public Input() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setFocusable(true);
        frame.setFocusTraversalKeysEnabled(false);

        JPanel panel = new JPanel();
        JLabel up = new JLabel();
        JLabel down = new JLabel();
        JLabel left = new JLabel();
        JLabel right = new JLabel();

        panel.add(up);
        panel.add(down);
        panel.add(left);
        panel.add(right);

        up.setText("Up : 0");
        down.setText("Down : 0");
        left.setText("Left : 0");
        right.setText("Right : 0");

        
        time.start();

        frame.addKeyListener(new KeyListener(){

            int upCount = 0;
            int downCount = 0;
            int leftCount = 0;
            int rightCount = 0;

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch(keyCode) {
                    case KeyEvent.VK_UP:
                        velX = 0;
                        velY = 1;
                        break;
                    case KeyEvent.VK_DOWN:
                        velX = 0;
                        velY = -1;
                        break;
                    case KeyEvent.VK_LEFT:
                        velX = -1;
                        velY = 0;
                        break;
                    case KeyEvent.VK_RIGHT:
                        velX = 1;
                        velY = 0;
                        break;
                }
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });

        frame.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += velX;
        y += velY;
       
    }
    public static void main(String args[]) {
        new Input();
        
    }


    
}
