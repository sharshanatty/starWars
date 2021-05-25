package com.company.ship;

import java.awt.*;

public abstract class Ship implements Move, ToAttack {
    protected int x = 10, y = 10;
    protected int speed = 10;
    protected double rotate = 0;
    protected double rSpeed = 0.1;
    protected boolean LEFT = false, RIGHT = false, UP = false, DOWN = false;
    protected Image avatar;

    public void setLEFT(boolean LEFT) {
        this.LEFT = LEFT;
    }

    public void setRIGHT(boolean RIGHT) {
        this.RIGHT = RIGHT;
    }

    public void setUP(boolean UP) {
        this.UP = UP;
    }

    public void setDOWN(boolean DOWN) {
        this.DOWN = DOWN;
    }

    public Ship() {

    }

    public Ship(int x, int y) {
        this();
        moveTo(x, y);
    }

    @Override
    public void move() {
        int dx = (int) (Math.cos(rotate) * speed);
        int dy = (int) (Math.sin(rotate) * speed);

        if(UP) {
            x -= dx;
            y -= dy;
        }

        if(DOWN) {
            x += dx;
            y += dy;
        }

        if(RIGHT) rotate += rSpeed;
        if(LEFT) rotate -= rSpeed;
    }

    @Override
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public abstract void toAttack();

    public void draw(Graphics g) {
        if(avatar == null) {
            g.drawRect(x, y, 100, 100);
        } else {
            Graphics2D g2d = (Graphics2D) g;
            g2d.rotate(rotate, x + avatar.getWidth(null) / 2, y + avatar.getHeight(null) / 2);
            g2d.drawImage(avatar, x, y, null);
            g2d.rotate(-rotate, x + avatar.getWidth(null) / 2, y + avatar.getHeight(null) / 2);
        }
    }
}
