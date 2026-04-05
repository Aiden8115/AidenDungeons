package com.aiden.dungeons.screen;

public abstract class AbstractScreen {
    public AbstractScreen() {
        this.init();
    }

    public abstract void init();

    public abstract void draw();

    public abstract void tick();

    public abstract void dispose();
}
