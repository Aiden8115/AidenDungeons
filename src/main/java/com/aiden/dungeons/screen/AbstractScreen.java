package com.aiden.dungeons.screen;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public abstract class AbstractScreen {
    public AbstractScreen parent;

    public AbstractScreen(Pane pane) {
        this.load(pane);
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(0.01),
                actionEvent -> {
                    this.tick(actionEvent, pane);
                }
        ));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public abstract void load(Pane pane);

    public abstract void tick(ActionEvent event, Pane pane);

    public abstract void close(Pane pane);
}
