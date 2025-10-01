package com.patterns.behavioral.observer;
public class BBCChannel implements NewsChannel {
    @Override public void update(String news) { System.out.println("BBC Breaking News: " + news); }
}