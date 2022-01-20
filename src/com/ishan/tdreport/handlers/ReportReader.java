package com.ishan.tdreport.handlers;

public interface ReportReader {
    void readFile(String path);
    void setRowDataHandler(ReportWriter writer);
}
