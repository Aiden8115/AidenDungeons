package com.aiden.dungeons;

import com.aiden.dungeons.screen.TitleScreen;
import com.aiden.dungeons.util.CursorManager;
import com.aiden.dungeons.util.FontUtil;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AidenDungeons extends ApplicationAdapter {
    protected static AidenDungeons INSTANCE;
    private SpriteBatch batch;
    private TitleScreen titleScreen;
    public static final String VERSION = "0.0.1";

    @Override
    public void create() {
        batch = new SpriteBatch();
        FontUtil.create();

        this.titleScreen = new TitleScreen();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        titleScreen.draw();
        batch.end();

        titleScreen.tick();
        CursorManager.updateCursor();
    }

    @Override
    public void dispose() {
        batch.dispose();
        titleScreen.dispose();
        FontUtil.disposeGenerator();
    }

    public static AidenDungeons getInstance() {
        return INSTANCE;
    }

    public SpriteBatch getBatch() {
        return batch;
    }
}
