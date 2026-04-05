package com.aiden.dungeons.button;

import com.aiden.dungeons.util.CursorManager;
import com.aiden.dungeons.util.FontUtil;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public abstract class AbstractButton {
    public BitmapFont font;
    public String text;
    public float x, y;
    public float boxWidth;

    public AbstractButton(String text, float x, float y, float boxWidth) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.boxWidth = boxWidth;
        this.init();
    }

    public abstract void onClicked();

    public void init() {
        this.font = FontUtil.generateFont(32);

        CursorManager.registerHoverChecker(this::updateCursor);
    }

    private Boolean updateCursor() {
        boolean bl = isHovered();
        if (bl) Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand);
        return bl;
    }

    public void tick() {
        if (this.isClicked()) {
            this.onClicked();
        }
    }

    public boolean isClicked() {
        if (!Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) return false;

        float mx = (float) Gdx.input.getX() / Gdx.graphics.getWidth() * 1000;
        float my = (float) (Gdx.graphics.getHeight() - Gdx.input.getY()) / Gdx.graphics.getHeight() * 600;

        float textW = FontUtil.getLayoutWidth(text, font);
        float textH = FontUtil.getLayoutHeight(text, font);

        float left = x - Math.max(textW, boxWidth) / 2 - 12;
        float right = x + Math.max(textW, boxWidth) / 2 + 12;
        float bottom = y - textH / 2 - 12;
        float top = y + textH / 2 + 12;

        return mx >= left && mx <= right && my >= bottom && my <= top;
    }

    public boolean isHovered() {
        float mx = (float) Gdx.input.getX() / Gdx.graphics.getWidth() * 1000;
        float my = (float) (Gdx.graphics.getHeight() - Gdx.input.getY()) / Gdx.graphics.getHeight() * 600;

        float textW = FontUtil.getLayoutWidth(text, font);
        float textH = FontUtil.getLayoutHeight(text, font);

        float left = x - Math.max(textW, boxWidth) / 2 - 12;
        float right = x + Math.max(textW, boxWidth) / 2 + 12;
        float bottom = y - textH / 2 - 12;
        float top = y + textH / 2 + 12;

        return mx >= left && mx <= right && my >= bottom && my <= top;
    }

    public void draw() {
        if (isHovered()) {
            FontUtil.drawFontWithBorder(font, text, x, y, boxWidth, Color.valueOf("0000FF"));
        } else {
            FontUtil.drawFontWithBorder(font, text, x, y, boxWidth, Color.WHITE);
        }
    }

    public void dispose() {
        CursorManager.unregisterHoverChecker(this::updateCursor);
        font.dispose();
    }
}
