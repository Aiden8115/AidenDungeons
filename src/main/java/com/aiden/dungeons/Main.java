package com.aiden.dungeons;

import com.aiden.dungeons.util.DungeonsLabel;
import com.aiden.dungeons.util.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static final Logger LOGGER = new Logger();
    public Scene scene;

    public static void main(String[] args) {
        LOGGER.info("Launching AidenDungeons...");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        LOGGER.info("Game Launched! ");

        LOGGER.info("Loading title...");
        stage.setTitle("Aiden's Dungeons");
        LOGGER.info("Title loaded: " + stage.getTitle());

        LOGGER.info("Loading \"root\" stack pane...");
        StackPane root = new StackPane();
        LOGGER.info("\"root\" stack pane loaded");

        DungeonsLabel label = DungeonsLabel.Builder.create()
                .value("Hello World!")
                .build(root);

        this.scene = new Scene(root, 1000, 618);
        stage.setScene(scene);
        stage.show();
    }
}
