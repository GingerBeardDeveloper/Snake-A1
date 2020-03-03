package com.gamecodeschool.c17snake;

abstract class MoveableObject extends GameObject implements IMovable {
    // TODO: Add documentation comments

    public MoveableObject() {
        super();
    }

    // For tracking movement Heading
    protected enum Heading {
        UP, RIGHT, DOWN, LEFT
    }
    protected Heading heading;

    /**
     *
     * @param clockwise Direction to rotate the MoveableObject. Rotates clockwise if true and counterclockwise if false.
     */
    public void rotateHeading(boolean clockwise) {
        if (clockwise) {
            switch (heading) {
                // Rotate clockwise
                case UP:
                    heading = Heading.RIGHT;
                    break;
                case RIGHT:
                    heading = Heading.DOWN;
                    break;
                case DOWN:
                    heading = Heading.LEFT;
                    break;
                case LEFT:
                    heading = Heading.UP;
                    break;

            }
        } else {
            // Rotate counter-clockwise
            switch (heading) {
                case UP:
                    heading = Heading.LEFT;
                    break;
                case LEFT:
                    heading = Heading.DOWN;
                    break;
                case DOWN:
                    heading = Heading.RIGHT;
                    break;
                case RIGHT:
                    heading = Heading.UP;
                    break;
            }
        }
    }

    // Moves the head based on the current heading
    @Override
    public void move() {
        // Move it appropriately
        switch (heading) {
            case UP:
                location.y--;
                break;

            case RIGHT:
                location.x++;
                break;

            case DOWN:
                location.y++;
                break;

            case LEFT:
                location.x--;
                break;
        }
    }

    protected Heading getHeading() {
        return heading;
    }

    protected void setHeading(Heading newHeading) {
        heading = newHeading;
    }

}
