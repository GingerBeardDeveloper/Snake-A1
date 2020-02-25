package com.gamecodeschool.c17snake;

abstract class Point {
    // Every point has an x and y value
    private float x, y;

    public Point(float setX, float setY) {
        this.x = setX;
        this.y = setY;
    }

    // Setters for point class
    public void setX(float newX) {
        this.x = newX;
    }

    public void setY(float newY) {
        this.y = newY;
    }

    // Getters for point class
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}