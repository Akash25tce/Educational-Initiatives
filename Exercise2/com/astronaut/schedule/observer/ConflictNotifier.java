package com.astronaut.schedule.observer;

import com.astronaut.schedule.util.AppLogger;

public class ConflictNotifier implements Observer {
    @Override
    public void update(String message) {
        AppLogger.logError("NOTIFICATION: " + message);
    }
}