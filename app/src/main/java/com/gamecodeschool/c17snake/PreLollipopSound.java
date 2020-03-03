package com.gamecodeschool.c17snake;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

import java.io.IOException;

//Class is instantiated when Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP
public class PreLollipopSound implements SoundStrategy {

    // for playing sound effects
    private SoundPool mSP;
    private int mEat_ID = -1;
    private int mCrashID = -1;

    public PreLollipopSound() {
           mSP = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
    }

    @Override
    public void prepareSounds(AssetManager assetManager) {
        try {
            AssetFileDescriptor descriptor;

            // Prepare the sounds in memory
            descriptor = assetManager.openFd("get_apple.ogg");
            mEat_ID = mSP.load(descriptor, 0);

            descriptor = assetManager.openFd("snake_death.ogg");
            mCrashID = mSP.load(descriptor, 0);
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }

    public void playEatAppleSound() {
        this.mSP.play(this.mEat_ID, 1, 1, 0, 0, 1);
    }

    public void playDeathSound() {
        this.mSP.play(mCrashID, 1, 1, 0, 0, 1);
    }
}