package com.gamecodeschool.c17snake;

public class SoundContext {
    private SoundStrategy strategy;

    public void setSoundStrategy(SoundStrategy strategy) {
        this.strategy = strategy;
    }

    public SoundStrategy getStrategy() {
        return strategy;
    }
}
