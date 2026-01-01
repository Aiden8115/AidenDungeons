package com.aiden.dungeons.button;

import com.aiden.dungeons.Dungeons;
import com.aiden.dungeons.screen.AbstractScreen;
import com.aiden.dungeons.util.DungeonsLabel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public abstract class AbstractButton {
    public AbstractScreen screen;
    public DungeonsLabel label;

    public AbstractButton(String text, double xMultiplier, double yMultiplier) {
        this.label = DungeonsLabel.Builder.create()
                .value(text)
                .size(30)
                .build();
        this.label.setAlignment(Pos.CENTER);
        this.label.setPrefWidth(500);
        this.label.setPrefHeight(50);
        StackPane.setAlignment(this.label, Pos.TOP_LEFT);
        // translate the label using a timeline!
        Timeline timeline = getTranslationTimeline(xMultiplier, yMultiplier);
        timeline.play();
        // set the color
        this.label.setBackground(Background.fill(Color.DARKTURQUOISE));
        this.label.setBorder(new Border(new BorderStroke(
                Color.RED,
                BorderStrokeStyle.SOLID,
                new CornerRadii(0),
                new BorderWidths(5)
        )));
        this.label.setOnMouseEntered(event -> {
            this.label.setBorder(new Border(new BorderStroke(
                    Color.YELLOW,
                    BorderStrokeStyle.SOLID,
                    new CornerRadii(0),
                    new BorderWidths(5)
            )));
            event.consume();
        });
        this.label.setOnMouseExited(event -> {
            this.label.setBorder(new Border(new BorderStroke(
                    Color.RED,
                    BorderStrokeStyle.SOLID,
                    new CornerRadii(0),
                    new BorderWidths(5)
            )));
            event.consume();
        });
        this.label.setOnMousePressed(event -> {
            onClicked(event);
            event.consume();
        });
    }

    private Timeline getTranslationTimeline(double xMultiplier, double yMultiplier) {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(0.001),
                actionEvent -> {
                    if (this.label.isVisible()) {
                        this.label.setTranslateX(-this.label.getPrefWidth() / 2 + Dungeons.getWidth() * xMultiplier);
                        this.label.setTranslateY(-this.label.getPrefHeight() / 2 + Dungeons.getHeight() * yMultiplier);
                    }
                }
        ));
        timeline.setCycleCount(Timeline.INDEFINITE);
        return timeline;
    }

    public abstract void onClicked(MouseEvent event);
}
