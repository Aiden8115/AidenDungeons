package com.aiden.dungeons.util;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.InputStream;

public class DungeonsImageView extends ImageView {
    private DungeonsImageView(Image image, double fitWidth, double fitHeight, boolean preserveRatio) {
        super(image);
        this.setFitWidth(fitWidth);
        this.setFitHeight(fitHeight);
        this.setPreserveRatio(preserveRatio);
    }

    public void remove() {
        ((Pane) this.getParent()).getChildren().remove(this);
    }

    public static class Builder {
        private Image image;
        private double fitWidth = 0;
        private double fitHeight = 0;
        private boolean preserveRatio = true;

        public Builder() {}

        public static Builder create() {
            return new Builder();
        }

        public Builder image(String resourcePath) {
            InputStream inputStream = this.getClass().getResourceAsStream(resourcePath);
            if (inputStream != null) {
                this.image = new Image(inputStream);
            } else {
                throw new IllegalArgumentException("图片资源不存在: " + resourcePath);
            }
            return this;
        }

        public Builder fitWidth(double fitWidth) {
            this.fitWidth = fitWidth;
            return this;
        }

        public Builder fitHeight(double fitHeight) {
            this.fitHeight = fitHeight;
            return this;
        }

        public Builder preserveRatio(boolean preserveRatio) {
            this.preserveRatio = preserveRatio;
            return this;
        }

        public DungeonsImageView build(StackPane pane) {
            DungeonsImageView imageView = new DungeonsImageView(image, fitWidth, fitHeight, preserveRatio);
            pane.getChildren().add(imageView);
            return imageView;
        }
    }
}
