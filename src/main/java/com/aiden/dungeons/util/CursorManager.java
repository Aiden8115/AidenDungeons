package com.aiden.dungeons.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class CursorManager {
    private static final List<Supplier<Boolean>> hoverCheckers = new ArrayList<>();

    public static void registerHoverChecker(Supplier<Boolean> checker) {
        hoverCheckers.add(checker);
    }

    public static void unregisterHoverChecker(Supplier<Boolean> checker) {
        hoverCheckers.remove(checker);
    }

    public static void updateCursor() {
        boolean anyHovered = false;
        for (Supplier<Boolean> checker : hoverCheckers) {
            try {
                anyHovered = anyHovered || checker.get();
            } catch (Exception ignored) {}
        }

        if (!anyHovered) {
            Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
        }
    }
}
