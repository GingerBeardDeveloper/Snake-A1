package com.gamecodeschool.c17snake;

abstract class Point {

    // TODO: Add documentation comments
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

    /**
     *
     * @return Returns point y value
     */
    public float getY() {
        return y;
    }
}