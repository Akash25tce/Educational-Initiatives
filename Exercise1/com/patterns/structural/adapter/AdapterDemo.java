package com.patterns.structural.adapter;
public class AdapterDemo {
    public static void main(String[] args) {
        CsvReport oldReport = new CsvReport();
        JsonReport adapter = new CsvToJsonAdapter(oldReport);
        System.out.println("Legacy CSV Data: " + oldReport.getCsvData());
        System.out.println("Adapted JSON Data: " + adapter.getJsonData());
    }
}