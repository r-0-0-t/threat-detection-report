package com.ishan.tdreport.handlers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class CsvReportReader implements ReportReader {

    private ReportWriter reportWriter;

    public CsvReportReader(ReportWriter reportWriter) {
        this.reportWriter = reportWriter;
    }

    public CsvReportReader() {

    }

    @Override
    public void readFile(String filePath)  {
        try {
            String line = "";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            // First line of csv file contains header information
            line = reader.readLine();

            while((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if(reportWriter != null) reportWriter.handleRow(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setRowDataHandler(ReportWriter writer) {
        this.reportWriter = writer;
    }

}
