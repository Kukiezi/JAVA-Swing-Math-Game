package com.company;

import com.sun.jdi.ThreadReference;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

public class Game extends JPanel implements ActionListener, KeyListener {

    Timer tm = new Timer(1, this);
    int x = 350, y = 550;
    double velX = 0, velY = 0;
    private Color rectColor = Color.ORANGE;

    public Game() {
        tm.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setBackground(Color.BLACK);
    }

    public void changeColorSuccess() {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                rectColor = Color.GREEN;
            }
        });
    }

    public void changeColorFail() {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                rectColor = Color.RED;
            }
        });
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(rectColor);
        g.fillRect(x, y, 100, 10);
    }

    public void left() {
        if (x > 0) {
            velX = -1;
        }
    }

    public void right() {
        if (x < 700) {
            velX = 1;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        if (x + velX > 0 && x + velX < 700) {
            x += velX;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            left();
        } else if (code == KeyEvent.VK_RIGHT) {
            right();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_RIGHT) {
            velX = 0;
        }
    }
}
