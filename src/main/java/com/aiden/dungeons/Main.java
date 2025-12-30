package com.aiden.dungeons;

public class Main {
    public static void main(String[] args) {
        Dungeons.LOGGER.info("Launching AidenDungeons...");
        Dungeons.LOGGER.warn("The warning \" Unsupported JavaFX configuration: classes were loaded from 'unnamed module @????????' \" is normal, so fell free to ignore it. ");
        Dungeons.dungeonsMain(args);
    }
}
