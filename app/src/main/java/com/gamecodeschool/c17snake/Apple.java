package com.gamecodeschool.c17snake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.widget.Switch;

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
    }

    // This is called every time an apple is eaten
    void spawn(){
        // Choose two random values and place the apple
        Random random = new Random();
        location.x = random.nextInt(mSpawnRange.x) + 1;
        location.y = random.nextInt(mSpawnRange.y - 1) + 1;
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

    class AppleBuilder {

        private Context context;
        private Point location = new Point();
        private Point spawnRange;
        private int size;
        private boolean good;
        private Random rand = new Random();

        AppleBuilder(Context context) {
            this.context = context;
        }

        AppleBuilder(Context context, Point sr, int s, boolean good) {
            this.context = context;
            this.spawnRange = sr;
            this.size = s;
            this.location.x = -10;
            this.good = good;
        }

        public void setLocation(Point location) {
            this.location = location;
        }

        public void setSpawnRange(Point spawnRange) {
            this.spawnRange = spawnRange;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public Apple build() {
            // Randomly decides if apple is bad with 20% chance to be a bad apple
            int isBad = rand.nextInt(5);
            if (isBad == 0) {
                good = false;
            }
            return new Apple(context, spawnRange, size, good);
        }
    }
}