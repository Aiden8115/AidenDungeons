package com.aiden.dungeons;

import com.aiden.dungeons.key_binding.KeyBinding;
import com.aiden.dungeons.screen.AbstractScreen;
import com.aiden.dungeons.screen.TitleScreen;
import com.aiden.dungeons.util.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Dungeons extends Application {
    public static final Logger LOGGER = new Logger();
    public static Scene SCENE;
    private static double WIDTH = 1000;
    private static double HEIGHT = 618;
    public static AbstractScreen CURRENT_SCREEN;
    public static StackPane ROOT_PANE;

    public static void dungeonsMain(String... args) {
        launch(args);
        quitSys();
    }

    @Override
    public void start(Stage stage) throws Exception {
        LOGGER.info("Game launched! ");

        LOGGER.info("Loading the stage and title...");
        stage.setWidth(1000); stage.setHeight(618);
        stage.setMinHeight(618); stage.setMinWidth(1000);
        stage.setTitle("Aiden's Dungeons");
        LOGGER.info("Title loaded: " + stage.getTitle());

        LOGGER.info("Loading \"root\" stack pane...");
        ROOT_PANE = new StackPane();
        ROOT_PANE.setBackground(new Background(new BackgroundFill(
                Color.color(0, 0, 0),
                null, null
        )));
        LOGGER.info("\"root\" stack pane loaded");

        LOGGER.info("Loading scene...");
        SCENE = new Scene(ROOT_PANE, WIDTH, HEIGHT);
        stage.setScene(SCENE);
        stage.show();

        KeyBinding.registerAllKeyBindings(stage);

        CURRENT_SCREEN = new TitleScreen();

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(0.001),
                actionEvent -> {
                    // update the width and height of the stage
                    if (stage.getHeight() != HEIGHT) HEIGHT = stage.getHeight();
                    if (stage.getWidth() != WIDTH) WIDTH = stage.getWidth();
                }
        ));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        LOGGER.info("Game load completely! ");
    }

    public static double getWidth() {
        return WIDTH;
    }

    public static double getHeight() {
        return HEIGHT;
    }

    public static void setCurrentScreen(AbstractScreen screen) {
        CURRENT_SCREEN.close();
        CURRENT_SCREEN = screen;
    }

    public static void quitSys() {
        LOGGER.info("Stopping! ");
        System.exit(0);
    }
}
