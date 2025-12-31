package com.aiden.dungeons.button;

import com.aiden.dungeons.Dungeons;
import com.aiden.dungeons.screen.AbstractScreen;
import com.aiden.dungeons.screen.Floor1Screen;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class StartButton extends AbstractButton {
    public Floor1Screen floor1Screen;

    public StartButton(Pane pane, AbstractScreen screen) {
        super(pane, "Start", 0.5, 0.4);
        this.screen = screen;
    }

    @Override
    public void onClicked(Pane pane, MouseEvent event) {
        screen.close(pane);
        this.floor1Screen = new Floor1Screen(pane, screen);
    }
}
