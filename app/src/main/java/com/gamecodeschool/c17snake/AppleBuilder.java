package com.gamecodeschool.c17snake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import java.util.Random;


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
