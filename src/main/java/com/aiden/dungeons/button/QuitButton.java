package com.aiden.dungeons.button;

import com.aiden.dungeons.Dungeons;
import com.aiden.dungeons.screen.AbstractScreen;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class QuitButton extends AbstractButton {
    public QuitButton(Pane pane, AbstractScreen screen) {
        super(pane, "Quit Game", 0.5, 0.6);
        this.screen = screen;
    }

    @Override
    public void onClicked(Pane pane, MouseEvent event) {
        Dungeons.quitSys();
    }
}
