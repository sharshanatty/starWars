package com.company.ship;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class HumanShip extends Ship{
    Bullet bullet;

    public HumanShip() {
        this.speed = 5;
        this.rSpeed = 0.07;
        try {
            avatar = ImageIO.read(new File("humanShip.png")).getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HumanShip(int x, int y) {
        this();
        moveTo(x, y);
    }

    @Override
    public void toAttack() {
        bullet = new Bullet(x + avatar.getWidth(null) / 2, y + avatar.getHeight(null) / 2, rotate);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        if(bullet != null) {
            bullet.move();
            bullet.draw(g);
        }
    }
}
