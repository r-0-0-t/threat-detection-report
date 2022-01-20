package com.ishan.tdreport.reportgenerators;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public abstract class CsvReportGenerator implements ReportGenerator {

    public void readReport(String filePath)  {
        try {
            String line = "";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            // First line of csv file contains header information
            line = reader.readLine();

            while((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                handleRow(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract void handleRow(String[] row);

}
