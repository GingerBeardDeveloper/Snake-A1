package com.gamecodeschool.c17snake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;

import androidx.annotation.CallSuper;

import java.util.ArrayList;

class Snake extends MoveableObject {
    private Head head;
    Context context;

    // TODO: Add documentation comments
    // TODO: Refactor to be object oriented code

    // The location in the grid of all the segments
    private ArrayList<MoveableObject> segments;

    // How big is each segment of the snake?
    private int mSegmentSize;

    // How big is the entire grid
    private Point mMoveRange;

    // Where is the centre of the screen
    // horizontally in pixels?
    private int halfWayPoint;


    Snake(Context context, Point mr, int ss) {
        this.context = context;
        head = new Head(context, mr, ss);

        // Initialize our ArrayList
        segments = new ArrayList<>();

        // Initialize the segment size and movement
        // range from the passed in parameters
        mSegmentSize = ss;
        mMoveRange = mr;

        // The halfway point across the screen in pixels
        // Used to detect which side of screen was pressed
        halfWayPoint = mr.x * ss / 2;
    }

    // Get the snake ready for a new game
    void reset(int w, int h) {

        // Reset the heading
        heading = Heading.RIGHT;

        // Delete the old contents of the ArrayList
        segments.clear();

        // Start with a single snake segment
        segments.add(head);
        head.setLocation(new Point(w / 2, h / 2));
    }


    public void move() {
        head.move();
        // Move the body
        // Start at the back and move it
        // to the position of the segment in front of it
        for (int i = 1; i < segments.size(); i++) {
            segments.get(i).heading = segments.get(i - 1).heading;
        }
    }

    boolean detectDeath() {
        // Has the snake died?
        boolean dead = false;

        // Hit any of the screen edges
        if (head.location.x == -1 ||
                head.location.x > mMoveRange.x ||
                head.location.y == -1 ||
                head.location.y > mMoveRange.y) {

            dead = true;
        }

        // Eaten itself?
        for (int i = segments.size() - 1; i > 0; i--) {
            // Have any of the sections collided with the head
            if (segments.get(0).location.x == segments.get(i).location.x &&
                    segments.get(0).location.y == segments.get(i).location.y) {

                dead = true;
            }
        }
        return dead;
    }

    boolean checkDinner(Point l) {
        //if (snakeXs[0] == l.x && snakeYs[0] == l.y) {
        if (segments.get(0).location.x == l.x &&
                segments.get(0).location.y == l.y) {

            // Add a new Point to the list
            // located off-screen.
            // This is OK because on the next call to
            // move it will take the position of
            // the segment in front of it
            segments.add(new Segment(context, mMoveRange, mSegmentSize));
            return true;
        }
        return false;
    }

    void draw(Canvas canvas, Paint paint) {

        // Don't run this code if ArrayList has nothing in it
        if (!segments.isEmpty()) {
            // All the code from this method goes here
            // Draw the head
            head.draw(canvas, paint);

            // Draw the snake body one block at a time
            for (int i = 1; i < segments.size(); i++) {
                segments.get(i).draw(canvas, paint);
            }
        }
    }

    @Override
    void setmBitmap(Context context, int s) {

    }


    // Handle changing direction
    void switchHeading(MotionEvent motionEvent) {
        head.rotateHeading(motionEvent.getX() >= halfWayPoint);
    }
}
