package com.company;

import com.company.ship.HumanShip;
import com.company.ship.MartianShip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel {
    HumanShip humanShip = new HumanShip(10, 10);
    MartianShip martianShip = new MartianShip(300, 300);

    public GamePanel() {
        setFocusable(true);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case 37 : humanShip.setLEFT(true); break;
                    case 39 : humanShip.setRIGHT(true); break;
                    case 38 : humanShip.setUP(true); break;
                    case 40 : humanShip.setDOWN(true); break;
                    case 32: humanShip.toAttack(); break;

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case 37 : humanShip.setLEFT(false); break;
                    case 39 : humanShip.setRIGHT(false); break;
                    case 38 : humanShip.setUP(false); break;
                    case 40 : humanShip.setDOWN(false); break;
                }
            }
        });

        new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                humanShip.move();
                repaint();
            }
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        humanShip.draw(g);
        martianShip.draw(g);
    }
}
