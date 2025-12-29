package com.aiden.dungeons.util;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.InputStream;

public class DungeonsLabel extends Label {
    private DungeonsLabel(String value, Font font, Color textFill) {
        super(value);
        this.setFont(font);
        this.setTextFill(textFill);
    }

    public static class Builder {
        private String value = "Default";
        private InputStream fontInputStream = this.getClass().getResourceAsStream("/assets/fonts/unifont-17.0.03.otf");
        private Font font = Font.loadFont(fontInputStream, 20);
        private Color textFill;

        public Builder() {
            this.textFill = Color.BLACK;
        }

        public static Builder create() {
            return new Builder();
        }

        public Builder value(String value) {
            this.value = value;
            return this;
        }

        public Builder font(String name, double size) {
            this.fontInputStream = this.getClass().getResourceAsStream("/assets/fonts/" + name);
            this.font = Font.loadFont(fontInputStream, size);
            return this;
        }

        public Builder textFill(Color color) {
            this.textFill = color;
            return this;
        }

        public DungeonsLabel build(StackPane pane) {
            DungeonsLabel label = new DungeonsLabel(value, font, textFill);
            pane.getChildren().add(label);
            return label;
        }
    }
}
