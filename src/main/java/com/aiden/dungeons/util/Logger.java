package com.aiden.dungeons.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSS");

    public void info(Object obj) {
        System.out.println("[" + colorStr(Colors.CYAN, LocalDateTime.now().format(DATE_TIME_FORMATTER)) + "] [" + colorStr(Colors.GREEN, "INFO") + "]  " + obj.toString());
    }

    public void warn(Object obj) {
        System.out.println("[" + colorStr(Colors.CYAN, LocalDateTime.now().format(DATE_TIME_FORMATTER)) + "] [" + colorStr(Colors.YELLOW, "WARN") + "]  " + colorStr(Colors.YELLOW, obj.toString()));
    }

    public void error(Object obj) {
        System.out.println("[" + colorStr(Colors.CYAN, LocalDateTime.now().format(DATE_TIME_FORMATTER)) + "] [" + colorStr(Colors.RED, "ERROR") + "] " + colorStr(Colors.RED, obj.toString()));
    }

    public String colorStr(Colors colors, String s){
        return switch (colors) {
            case BLACK -> "\033[30m" + s + "\033[0m";
            case RED -> "\033[31m" + s + "\033[0m";
            case GREEN -> "\033[32m" + s + "\033[0m";
            case YELLOW -> "\033[33m" + s + "\033[0m";
            case BLUE -> "\033[34m" + s + "\033[0m";
            case PURPLE -> "\033[35m" + s + "\033[0m";
            case CYAN -> "\033[36m" + s + "\033[0m";
            case WHITE -> "\033[37m" + s + "\033[0m";
            case GREEN_BOLD -> "\033[32;1m" + s + "\033[0m";
        };
    }

    public enum Colors {
        BLACK, RED, GREEN, YELLOW, BLUE, PURPLE, CYAN, WHITE, GREEN_BOLD
    }
}
