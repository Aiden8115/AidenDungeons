package com.aiden.dungeons;

import com.aiden.dungeons.screen.TitleScreen;
import com.aiden.dungeons.util.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Dungeons extends Application {
    public static final Logger LOGGER = new Logger();
    public Scene scene;

    public static void dungeonsMain(String... args) {
        launch(args);
        LOGGER.info("Stopping! ");
    }

    @Override
    public void start(Stage stage) throws Exception {
        LOGGER.info("Game launched! ");

        LOGGER.info("Loading the stage and title...");
        stage.setWidth(1000);
        stage.setHeight(618);
        stage.setTitle("Aiden's Dungeons");
        LOGGER.info("Title loaded: " + stage.getTitle());

        LOGGER.info("Loading \"root\" stack pane...");
        StackPane root = new StackPane();
        root.setBackground(new Background(new BackgroundFill(
                Color.color(0, 0, 0),
                null, null
        )));
        LOGGER.info("\"root\" stack pane loaded");

        TitleScreen titleScreen = new TitleScreen(root);

        this.scene = new Scene(root, 1000, 618);
        stage.setScene(scene);
        stage.setMinHeight(618);
        stage.setMinWidth(1000);
        stage.show();
        LOGGER.info("Game load completely! ");
    }
}
