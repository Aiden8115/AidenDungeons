package com.aiden.dungeons.button;

import com.aiden.dungeons.Dungeons;
import com.aiden.dungeons.screen.AbstractScreen;
import javafx.scene.input.MouseEvent;

public class QuitButton extends AbstractButton {
    public QuitButton(AbstractScreen screen) {
        super("Quit Game", 0.5, 0.6);
        this.screen = screen;
    }

    @Override
    public void onClicked(MouseEvent event) {
        Dungeons.quitSys();
    }
}
