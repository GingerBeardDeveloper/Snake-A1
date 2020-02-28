package com.gamecodeschool.c17snake;

abstract class MoveableObject extends GameObject {
    // TODO: Add documentation comments

    public MoveableObject() {
        super();
    }

    // For tracking movement Heading
    private enum Heading {
        UP, RIGHT, DOWN, LEFT
    }
    private Heading heading;

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

    /**
     *
     * @return
     */
    protected Heading getHeading() {
        return heading;
    }

    /**
     *
     * @param newHeading
     */
    protected void setHeading(Heading newHeading) {
        heading = newHeading;
    }

}
