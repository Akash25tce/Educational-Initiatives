package com.patterns.creational.factory;
public class NotificationFactory {
    public Notification createNotification(String channel) {
        if ("SMS".equalsIgnoreCase(channel)) {
            return new SMSNotification();
        } else if ("EMAIL".equalsIgnoreCase(channel)) {
            return new EmailNotification();
        }
        throw new IllegalArgumentException("Unknown channel " + channel);
    }
}