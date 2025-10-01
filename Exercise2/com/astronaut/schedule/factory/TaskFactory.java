package com.astronaut.schedule.factory;

import com.astronaut.schedule.model.Priority;
import com.astronaut.schedule.model.Task;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class TaskFactory {
    public static Task createTask(String description, String startTimeStr, String endTimeStr, String priorityStr) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty.");
        }
        try {
            LocalTime startTime = LocalTime.parse(startTimeStr);
            LocalTime endTime = LocalTime.parse(endTimeStr);
            if (endTime.isBefore(startTime) || endTime.equals(startTime)) {
                throw new IllegalArgumentException("End time must be after start time.");
            }
            Priority priority = Priority.valueOf(priorityStr.toUpperCase());
            return new Task(description, startTime, endTime, priority, false);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid time format. Please use HH:mm.", e);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid priority. Use HIGH, MEDIUM, or LOW.", e);
        }
    }
}