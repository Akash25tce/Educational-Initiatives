package com.patterns.structural.adapter;
public class CsvToJsonAdapter implements JsonReport {
    private final CsvReport csvReport;
    public CsvToJsonAdapter(CsvReport csvReport) { this.csvReport = csvReport; }

    @Override public String getJsonData() {
        String csv = csvReport.getCsvData();
        // Simplified conversion logic
        return "{\"data\": \"" + csv.replace("\n", " ") + "\"}";
    }
}