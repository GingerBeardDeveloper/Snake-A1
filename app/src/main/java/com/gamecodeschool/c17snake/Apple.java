package com.gamecodeschool.c17snake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

import java.util.Random;

class Apple extends GameObject {


    // The range of values we can choose from
    // to spawn an apple
    private Point mSpawnRange;

    // Is the apple a bad apple
    private boolean isGood;

    private int points;
    private Random rand;

    /// Set up the apple in the constructor
    Apple(Context context, Point sr, int s, boolean good){

        // Make a note of the passed in spawn range
        mSpawnRange = sr;
        // Make a note of the size of an apple
        mSize = s;
        // Hide the apple off-screen until the game starts
        location.x = -10;

        rand = new Random();
        isGood = good;
        if (good) {
            points = rand.nextInt(3);
        } else {
            points = -2;
        }

        // Load the image to the bitmap
        setmBitmap(context, s);
        spawn();
    }

    // This is called every time an apple is eaten
    void spawn(){
        // Choose two random values and place the apple
        location.x = rand.nextInt(mSpawnRange.x) + 1;
        location.y = rand.nextInt(mSpawnRange.y - 1) + 1;
    }

    public boolean isGood() {
        return isGood;
    }

    @Override
    void setmBitmap(Context context, int s) {
        if (isGood) {
            switch (points) {
                case 1:
                    mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.apple);
                    break;
                case 2:
                    mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.apple2points);
                    break;
                case 3:
                    mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.apple3points);
                    break;

            }
        }
        else {
            mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.badapple);
        }
        // Resize the bitmap

        mBitmap = Bitmap.createScaledBitmap(mBitmap, s, s, false);
    }
}