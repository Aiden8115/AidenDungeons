package com.aiden.dungeons.key_binding;

import com.aiden.dungeons.Dungeons;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class KeyBinding {
    public static void registerAllKeyBindings(Stage stage) {
        Dungeons.SCENE.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.F11) {
                stage.setFullScreen(!stage.isFullScreen());
            }
            if (event.getCode() == KeyCode.ESCAPE) {

            }
        });
    }
}
