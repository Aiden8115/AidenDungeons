package com.aiden.dungeons;

import com.aiden.dungeons.util.DungeonsLabel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    public Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Aiden's Dungeons");


        StackPane root = new StackPane();

        Label label = DungeonsLabel.Builder.create()
                .value("Hello World!")
                .build(root);

        this.scene = new Scene(root, 1000, 618);
        stage.setScene(scene);
        stage.show();
    }
}
