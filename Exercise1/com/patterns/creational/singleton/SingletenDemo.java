package com.patterns.creational.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();

        System.out.println("Config 1 DB URL: " + config1.getDatabaseUrl());
        System.out.println("Config 2 DB URL: " + config2.getDatabaseUrl());
        System.out.println("Are both instances the same? " + (config1 == config2));
    }
}