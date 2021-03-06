package com.gamecodeschool.c17snake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

class Segment extends MoveableObject implements IMovable{
    // How big is the entire grid
    private Point mMoveRange;

    public Segment(Context context, Point sr, int s) {

        mSize = s;
        mMoveRange = sr;
        setmBitmap(context, s);
        setLocation(sr);
    }

    @Override
    void setmBitmap(Context context, int s) {
        // Create and scale the body
        mBitmap = BitmapFactory
                .decodeResource(context.getResources(),
                        R.drawable.body);

        mBitmap = Bitmap
                .createScaledBitmap(mBitmap,
                        s, s, false);
    }
}
