package com.astronaut.schedule.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public record Task(String description, LocalTime startTime, LocalTime endTime, Priority priority, boolean completed) {
    public boolean overlapsWith(Task other) {
        return this.startTime.isBefore(other.endTime) && other.startTime.isBefore(this.endTime);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return String.format("%s - %s: %s [%s]%s",
                startTime.format(formatter),
                endTime.format(formatter),
                description,
                priority,
                completed ? " (Completed)" : "");
    }
}