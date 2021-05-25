package com.company.ship;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MartianShip extends Ship {
    public MartianShip() {
        this.speed = 7;
        this.rSpeed = 0.1;
        try {
            avatar = ImageIO.read(new File("martianShip.png")).getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MartianShip(int x, int y) {
        this();
        moveTo(x, y);
    }

    @Override
    public void toAttack() {

    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }
}
