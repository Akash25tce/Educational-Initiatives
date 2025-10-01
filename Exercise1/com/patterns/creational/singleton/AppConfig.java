package com.patterns.creational.singleton;

public class AppConfig {
    private static final AppConfig INSTANCE = new AppConfig();
    private String databaseUrl;

    // Private constructor to prevent instantiation
    private AppConfig() {
        // Simulate loading configuration
        this.databaseUrl = "jdbc:mysql://localhost:3306/prod_db";
    }

    public static AppConfig getInstance() {
        return INSTANCE;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }
}

