package com.gamecodeschool.c17snake;

import android.content.res.AssetManager;

public interface SoundStrategy {
    public void prepareSounds(AssetManager assetManager);
    public void playEatAppleSound();
    public void playDeathSound();
}