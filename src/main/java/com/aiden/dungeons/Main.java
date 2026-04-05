package com.aiden.dungeons;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class Main {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("AidenDungeons");
        config.setWindowedMode(1000, 600);
        AidenDungeons.INSTANCE = new AidenDungeons();
        Lwjgl3Application application = new Lwjgl3Application(AidenDungeons.INSTANCE, config);
    }
}
