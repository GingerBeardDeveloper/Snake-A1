package com.gamecodeschool.c17snake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

abstract class GameObject {
    // TODO: Add documentation comments
    // The location of the apple on the grid
    // Not in pixels
    protected android.graphics.Point location = new Point();
    protected int mSize;
    protected Bitmap mBitmap;

    public GameObject() {
    }

    void draw(Canvas canvas, Paint paint) {
        canvas.drawBitmap(mBitmap,
                location.x * mSize, location.y * mSize, paint);
    }

    public Point getLocation() {
        return location;
    }

    abstract void setmBitmap(Context context, int s);
}
