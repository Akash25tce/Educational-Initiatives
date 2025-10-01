package com.astronaut.schedule.manager;

import com.astronaut.schedule.model.Task;
import com.astronaut.schedule.observer.Observer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ScheduleManager {
    // 1. Singleton Pattern Implementation
    private static final ScheduleManager INSTANCE = new ScheduleManager();
    private final List<Task> tasks;
    private final List<Observer> observers;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        return INSTANCE;
    }

    // 3. Observer Pattern (Subject part)
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
    
    public boolean addTask(Task newTask) {
        for (Task existingTask : tasks) {
            if (newTask.overlapsWith(existingTask)) {
                notifyObservers("Task conflicts with existing task \"" + existingTask.description() + "\".");
                return false;
            }
        }
        tasks.add(newTask);
        tasks.sort(Comparator.comparing(Task::startTime));
        return true;
    }

    public boolean removeTask(String description) {
        Optional<Task> taskToRemove = tasks.stream()
                .filter(task -> task.description().equalsIgnoreCase(description))
                .findFirst();

        if (taskToRemove.isPresent()) {
            tasks.remove(taskToRemove.get());
            return true;
        }
        return false;
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks); // Return a copy to prevent external modification
    }
}