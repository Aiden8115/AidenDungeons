package com.aiden.dungeons.button;

import com.aiden.dungeons.screen.AbstractScreen;
import com.aiden.dungeons.screen.Floor1Screen;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class StartButton extends AbstractButton {
    public AbstractScreen screen;
    public Floor1Screen floor1Screen;

    public StartButton(Pane pane, AbstractScreen screen) {
        super(pane, "Start", 200);
        this.screen = screen;
    }

    @Override
    public void onClicked(Pane pane, MouseEvent event) {
        screen.close(pane);
        this.floor1Screen = new Floor1Screen(pane, screen);
    }
}
