package com.aiden.dungeons.util;

import org.lwjgl.util.tinyfd.TinyFileDialogs;

import java.io.File;

public class FileUtil {
    public static File openFile() {
        String path = TinyFileDialogs.tinyfd_openFileDialog(
                "AidenDungeons", "",
                null, "所有文件", false
        );
        if (path != null) {
            return new File(path);
        } else {
            return null;
        }
    }
}
