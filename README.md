Ei Company Assessment: Java Implementation
This repository contains my solution for the Ei Company coding assessment. The assessment is divided into two main parts:

Design Pattern Demonstrations – practical, real-world examples of classic GoF patterns.

Astronaut Daily Schedule Organizer – a console-based application that helps astronauts manage daily tasks in space.

The primary focus throughout is on clean code, SOLID principles, and maintainable design practices.

 Exercise 1: Design Pattern Demonstrations
This exercise demonstrates six key software design patterns. Each pattern is implemented in a self-contained package to showcase a practical, real-world use case.

Creational Patterns
Singleton
Concept: Ensures a class has only one instance and provides a global access point to it.
Implementation: AppConfig class provides a single source for application settings.
Path: exercise1/com/patterns/creational/singleton/

Factory
Concept: Creates objects without exposing the instantiation logic to the client.
Implementation: NotificationFactory builds different notification types (Email, SMS) on demand.
Path: exercise1/com/patterns/creational/factory/

Structural Patterns
Adapter
Concept: Acts as a bridge between two incompatible interfaces.
Implementation: CsvToJsonAdapter allows a modern JSON-based system to consume data from a legacy CSV-based system.
Path: exercise1/com/patterns/structural/adapter/

Decorator
Concept: Adds new functionality to an object dynamically by wrapping it.
Implementation: A base Coffee object is decorated with MilkDecorator or SugarDecorator to modify its cost and description.
Path: exercise1/com/patterns/structural/decorator/

Behavioral Patterns
Strategy
Concept: Defines a family of interchangeable algorithms that can be selected at runtime.
Implementation: A ShoppingCart uses different PaymentStrategy objects (Credit Card, PayPal) to process payments.
Path: exercise1/com/patterns/behavioral/strategy/

Observer
Concept: When a "subject" object changes state, all its "observer" dependents are notified automatically.
Implementation: A NewsAgency (Subject) notifies all subscribed NewsChannels (Observers) when a new story is published.
Path: exercise1/com/patterns/behavioral/observer/

Exercise 2: Astronaut Daily Schedule Organizer
This is a console-based scheduling application designed to help astronauts manage their daily activities. It simulates real-world requirements such as task prioritization, scheduling conflicts, and data consistency.

Features
Add Task: Create tasks with description, start time, end time, and priority.
Remove Task: Delete tasks by description.
View All Tasks: Display all scheduled tasks sorted by start time.
Conflict Detection: Prevents creation of overlapping tasks.
Error Handling: Provides clear error messages for invalid inputs (e.g., wrong time format, task not found).


Architecture and Design Choices
The application's architecture is built on key design patterns to ensure a clean, robust, and maintainable codebase.

Singleton (ScheduleManager): Provides a single source of truth for all tasks, ensuring data consistency across the application.

Factory (TaskFactory): Encapsulates the complex logic of task creation and validation, keeping client code simple and clean.

Observer (ConflictNotifier): Decouples conflict detection (in the manager) from conflict notification (to the user), making the system more modular.
