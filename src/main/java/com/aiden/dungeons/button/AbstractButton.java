package com.aiden.dungeons.button;

import com.aiden.dungeons.screen.AbstractScreen;
import com.aiden.dungeons.util.DungeonsLabel;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public abstract class AbstractButton {
    public AbstractScreen screen;
    public DungeonsLabel label;

    public AbstractButton(Pane pane, String text, double translateY) {
        this.label = DungeonsLabel.Builder.create()
                .value(text)
                .size(30)
                .build(pane);
        this.label.setAlignment(Pos.CENTER);
        this.label.setPrefWidth(500);
        this.label.setPrefHeight(50);
        StackPane.setAlignment(this.label, Pos.TOP_CENTER);
        this.label.setTranslateY(translateY);
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
            onClicked(pane, event);
            event.consume();
        });
    }

    public abstract void onClicked(Pane pane, MouseEvent event);
}
