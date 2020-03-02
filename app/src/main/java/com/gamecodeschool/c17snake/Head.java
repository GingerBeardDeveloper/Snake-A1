package com.gamecodeschool.c17snake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;

class Head extends MoveableObject {
    // TODO: Add documentation comments

    // TODO: Define file for BMap
    // A bitmap for each direction the head can face
    private Bitmap mBitmapHeadRight;
    private Bitmap mBitmapHeadLeft;
    private Bitmap mBitmapHeadUp;
    private Bitmap mBitmapHeadDown;

    // How big is the entire grid
    private Point mMoveRange;

    Head(Context context, Point sr, int s) {
        mSize = s;
        mMoveRange = sr;
        heading = Heading.RIGHT;

        setmBitmap(context, s);
    }

    @Override
    public void rotateHeading(boolean clockwise) {
        if (clockwise) {
            switch (heading) {
                // Rotate clockwise
                case UP:
                    heading = Heading.RIGHT;
                    mBitmap = mBitmapHeadRight;
                    break;
                case RIGHT:
                    heading = Heading.DOWN;
                    mBitmap = mBitmapHeadDown;
                    break;
                case DOWN:
                    heading = Heading.LEFT;
                    mBitmap = mBitmapHeadLeft;
                    break;
                case LEFT:
                    heading = Heading.UP;
                    mBitmap = mBitmapHeadUp;
                    break;

            }
        } else {
            // Rotate counter-clockwise
            switch (heading) {
                case UP:
                    heading = Heading.LEFT;
                    mBitmap = mBitmapHeadLeft;
                    break;
                case LEFT:
                    heading = Heading.DOWN;
                    mBitmap = mBitmapHeadDown;
                    break;
                case DOWN:
                    heading = Heading.RIGHT;
                    mBitmap = mBitmapHeadRight;
                    break;
                case RIGHT:
                    heading = Heading.UP;
                    mBitmap = mBitmapHeadUp;
                    break;
            }
        }
    }

    @Override
    void setmBitmap(Context context, int s) {
        // Create and scale the bitmaps
        mBitmapHeadRight = BitmapFactory
                .decodeResource(context.getResources(),
                        R.drawable.head);

        // Create 3 more versions of the head for different headings
        mBitmapHeadLeft = BitmapFactory
                .decodeResource(context.getResources(),
                        R.drawable.head);

        mBitmapHeadUp = BitmapFactory
                .decodeResource(context.getResources(),
                        R.drawable.head);

        mBitmapHeadDown = BitmapFactory
                .decodeResource(context.getResources(),
                        R.drawable.head);

        // Modify the bitmaps to face the snake head
        // in the correct direction
        mBitmapHeadRight = Bitmap
                .createScaledBitmap(mBitmapHeadRight,
                        s, s, false);

        // A matrix for scaling
        Matrix matrix = new Matrix();
        matrix.preScale(-1, 1);

        mBitmapHeadLeft = Bitmap
                .createBitmap(mBitmapHeadRight,
                        0, 0, s, s, matrix, true);

        // A matrix for rotating
        matrix.preRotate(-90);
        mBitmapHeadUp = Bitmap
                .createBitmap(mBitmapHeadRight,
                        0, 0, s, s, matrix, true);

        // Matrix operations are cumulative
        // so rotate by 180 to face down
        matrix.preRotate(180);
        mBitmapHeadDown = Bitmap
                .createBitmap(mBitmapHeadRight,
                        0, 0, s, s, matrix, true);
        mBitmap = mBitmapHeadRight;
    }
}
