package com.ishan.tdreport;

import com.ishan.tdreport.handlers.CsvReportReader;
import com.ishan.tdreport.handlers.ConsoleReportWriter;
import com.ishan.tdreport.handlers.ReportReader;
import com.ishan.tdreport.handlers.ReportWriter;


public class Main {

    public static void main(String[] args) {
        ReportReader reader = new CsvReportReader();
        ReportWriter writer = new ConsoleReportWriter();
        reader.setRowDataHandler(writer);
        reader.readFile("resources/threat_generator.csv");
        writer.showOutput();
    }
}
