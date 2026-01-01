package com.aiden.dungeons.button;

import com.aiden.dungeons.Dungeons;
import com.aiden.dungeons.screen.AbstractScreen;
import com.aiden.dungeons.screen.Floor1Screen;
import javafx.scene.input.MouseEvent;

public class StartButton extends AbstractButton {
    public StartButton(AbstractScreen screen) {
        super("Start", 0.5, 0.4);
        this.screen = screen;
    }

    @Override
    public void onClicked(MouseEvent event) {
        Dungeons.setCurrentScreen(new Floor1Screen(this.screen));
    }
}
