package com.astronaut.schedule;

import com.astronaut.schedule.factory.TaskFactory;
import com.astronaut.schedule.manager.ScheduleManager;
import com.astronaut.schedule.model.Task;
import com.astronaut.schedule.observer.ConflictNotifier;
import com.astronaut.schedule.util.AppLogger;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final ScheduleManager manager = ScheduleManager.getInstance();
    private static boolean isRunning = true; // Flag to control the main loop

    public static void main(String[] args) {
        // Register the observer
        manager.addObserver(new ConflictNotifier());
        
        Scanner scanner = new Scanner(System.in);
        AppLogger.logInfo("Astronaut Daily Schedule Organizer started.");

        while (isRunning) {
            printMenu();
            String choice = scanner.nextLine();
            handleUserChoice(choice, scanner);
        }
        
        AppLogger.logInfo("Application shutting down. Goodbye!");
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n--- Astronaut Schedule Menu ---");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. View All Tasks");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void handleUserChoice(String choice, Scanner scanner) {
        switch (choice) {
            case "1" -> addTask(scanner);
            case "2" -> removeTask(scanner);
            case "3" -> viewTasks();
            case "4" -> isRunning = false;
            default -> AppLogger.logError("Invalid choice. Please try again.");
        }
    }

    private static void addTask(Scanner scanner) {
        try {
            System.out.print("Enter description: ");
            String desc = scanner.nextLine();
            System.out.print("Enter start time (HH:mm): ");
            String start = scanner.nextLine();
            System.out.print("Enter end time (HH:mm): ");
            String end = scanner.nextLine();
            System.out.print("Enter priority (High, Medium, Low): ");
            String priority = scanner.nextLine();

            // Use the factory to create a task
            Task newTask = TaskFactory.createTask(desc, start, end, priority);
            
            if (manager.addTask(newTask)) {
                AppLogger.logInfo("Task added successfully. No conflicts.");
            } else {
                // The observer will have already printed the conflict message
            }
        } catch (Exception e) {
            AppLogger.logError("Failed to add task: " + e.getMessage());
        }
    }

    private static void removeTask(Scanner scanner) {
        System.out.print("Enter the description of the task to remove: ");
        String desc = scanner.nextLine();
        if (manager.removeTask(desc)) {
            AppLogger.logInfo("Task removed successfully.");
        } else {
            AppLogger.logError("Task not found.");
        }
    }

    private static void viewTasks() {
        List<Task> tasks = manager.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            System.out.println("\n--- Scheduled Tasks ---");
            tasks.forEach(System.out::println);
        }
    }
}