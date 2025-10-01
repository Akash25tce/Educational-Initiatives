package com.astronaut.schedule.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppLogger {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public static void logInfo(String message) {
        System.out.println(dtf.format(LocalDateTime.now()) + " [INFO] " + message);
    }

    public static void logError(String message) {
        System.err.println(dtf.format(LocalDateTime.now()) + " [ERROR] " + message);
    }
}