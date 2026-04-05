package com.aiden.dungeons.button;

import com.aiden.dungeons.screen.PlayerScreen;
import com.aiden.dungeons.util.FileUtil;

public class ImportPlayerDataButton extends AbstractButton {
    public ImportPlayerDataButton(float x, float y) {
        super("Import Player Data", x, y, 400.0F);
    }

    @Override
    public void onClicked() {
        PlayerScreen.currentPlayerDataFile = FileUtil.openFile();
    }
}
