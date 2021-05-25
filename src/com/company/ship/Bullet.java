package com.company.ship;

import java.awt.*;

public class Bullet implements  Move {
    protected int x = 10, y = 10;
    protected int speed = 50;
    protected double rotate = 0;

    public Bullet(int x, int y, double rotate) {
        moveTo(x, y);
        this.rotate = rotate;
    }

    @Override
    public void move() {
        int dx = (int)(Math.cos(rotate) * speed);
        int dy = (int)(Math.sin(rotate) * speed);
        x -= dx;
        y -= dy;
    }

    @Override
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void  draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.rotate(rotate, x, y);
        g2d.draw3DRect(x, y, 5, 5, false);
        g2d.rotate(-rotate, x, y);
    }
}
