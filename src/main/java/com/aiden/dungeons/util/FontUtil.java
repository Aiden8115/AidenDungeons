package com.aiden.dungeons.util;

import com.aiden.dungeons.AidenDungeons;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.function.Function;

public class FontUtil {
    private static GlyphLayout layout;
    private static FreeTypeFontGenerator unifontGenerator;
    private static boolean unifontGeneratorDisposed = false;
    private static ShapeRenderer shapeRenderer;

    public static void create() {
        layout = new GlyphLayout();
        unifontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("assets/fonts/unifont-17.0.03.otf"));
        shapeRenderer = new ShapeRenderer();
    }

    public static float getLayoutWidth(String text, BitmapFont font) {
        layout.setText(font, text);
        return layout.width;
    }

    public static float getLayoutHeight(String text, BitmapFont font) {
        layout.setText(font, text);
        return layout.height;
    }

    public static BitmapFont generateFont(Function<FreeTypeFontGenerator.FreeTypeFontParameter, FreeTypeFontGenerator.FreeTypeFontParameter> function) {
        return unifontGenerator.generateFont(function.apply(new FreeTypeFontGenerator.FreeTypeFontParameter()));
    }

    public static BitmapFont generateFont(int size) {
        return generateFont(freeTypeFontParameter -> {
            freeTypeFontParameter.size = size;
            return freeTypeFontParameter;
        });
    }

    public static void drawFont(BitmapFont font, String text, float x, float y) {
        font.draw(
                AidenDungeons.getInstance().getBatch(), text,
                x - getLayoutWidth(text, font) / 2F,
                y + getLayoutHeight(text, font) / 2F
        );
    }

    public static void drawFontWithBorder(BitmapFont font, String text, float x, float y, float width, Color color) {
        SpriteBatch batch = AidenDungeons.getInstance().getBatch();
        font.draw(
                batch, text,
                x - getLayoutWidth(text, font) / 2F,
                y + getLayoutHeight(text, font) / 2F
        );

        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);

        float f = getLayoutWidth(text, font) / 2F + 10;
        float g = getLayoutHeight(text, font) / 2F + 10;
        if (2 * f > width - 4) {
            shapeRenderer.rectLine(x - f - 2, y + g, x + f + 2, y + g, 4);
            shapeRenderer.rectLine(x + f, y + g + 2, x + f, y - g - 2, 4);
            shapeRenderer.rectLine(x + f + 2, y - g, x - f - 2, y - g, 4);
            shapeRenderer.rectLine(x - f, y - g - 2, x - f, y + g + 2, 4);
        } else {
            shapeRenderer.rectLine(x - width / 2F - 2, y + g, x + width / 2F + 2, y + g, 4);
            shapeRenderer.rectLine(x + width / 2F, y + g + 2, x + width / 2F, y - g - 2, 4);
            shapeRenderer.rectLine(x + width / 2F + 2, y - g, x - width / 2F - 2, y - g, 4);
            shapeRenderer.rectLine(x - width / 2F, y - g - 2, x - width / 2F, y + g + 2, 4);
        }
        shapeRenderer.end();
        batch.begin();
    }

    public static void disposeGenerator() {
        if (!unifontGeneratorDisposed) {
            unifontGenerator.dispose();
            unifontGeneratorDisposed = true;
        }
    }
}
