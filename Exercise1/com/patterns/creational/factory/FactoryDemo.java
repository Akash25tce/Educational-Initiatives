package com.patterns.creational.factory;
public class FactoryDemo {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();
        Notification email = factory.createNotification("EMAIL");
        email.send("Hello via Email!");

        Notification sms = factory.createNotification("SMS");
        sms.send("Hello via SMS!");
    }
}