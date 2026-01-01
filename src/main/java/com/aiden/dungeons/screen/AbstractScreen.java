package com.aiden.dungeons.screen;

import com.aiden.dungeons.Dungeons;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

public abstract class AbstractScreen {
    public AbstractScreen parent;
    public boolean closed = false;

    public AbstractScreen() {
        this.load();
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(0.01),
                actionEvent -> {
                    if (!this.closed) {
                        this.tick(actionEvent);
                    }
                }
        ));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public abstract void load();

    public abstract void tick(ActionEvent event);

    public void close() {
        this.closed = true;
    }
}
