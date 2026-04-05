package com.aiden.dungeons.screen;

import com.aiden.dungeons.AidenDungeons;
import com.aiden.dungeons.button.AbstractButton;
import com.aiden.dungeons.button.ImportPlayerDataButton;
import com.aiden.dungeons.button.QuitButton;
import com.aiden.dungeons.util.FontUtil;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class TitleScreen extends AbstractScreen {
    private BitmapFont titleFont, versionFont;
    public AbstractButton quitButton;
    public AbstractButton importPlayerDataButton;

    public TitleScreen() {
        this.init();
    }

    @Override
    public void init() {
        titleFont = FontUtil.generateFont(64);
        versionFont = FontUtil.generateFont(16);

        quitButton = new QuitButton(500, 250);
        importPlayerDataButton = new ImportPlayerDataButton(500, 350);
    }

    @Override
    public void draw() {
        FontUtil.drawFont(titleFont, "AidenDungeons", 500, 500);
        FontUtil.drawFont(versionFont, "version " + AidenDungeons.VERSION, 900, 590);
        quitButton.draw();
        importPlayerDataButton.draw();
    }

    @Override
    public void tick() {
        quitButton.tick();
        importPlayerDataButton.tick();
    }

    @Override
    public void dispose() {
        titleFont.dispose();
        versionFont.dispose();
        quitButton.dispose();
        importPlayerDataButton.dispose();
    }
}
