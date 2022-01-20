package com.ishan.tdreport.handlers;

public interface ReportWriter {
    void showOutput();
    void handleRow(String[] row);
}
