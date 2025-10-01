package com.patterns.behavioral.observer;
public class ObserverDemo {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();
        BBCChannel bbc = new BBCChannel();

        agency.addObserver(bbc);
        agency.setNews("Astronauts land on Mars!");
    }
}