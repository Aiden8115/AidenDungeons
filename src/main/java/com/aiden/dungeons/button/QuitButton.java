package com.aiden.dungeons.button;

import com.badlogic.gdx.Gdx;

public class QuitButton extends AbstractButton {
    public QuitButton(float x, float y) {
        super("Quit Game", x, y, 400.0F);
    }

    @Override
    public void onClicked() {
        Gdx.app.exit();
    }
}
