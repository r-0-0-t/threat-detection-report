package com.ishan.tdreport;

import com.ishan.tdreport.reportgenerators.OutputGenerator;
import com.ishan.tdreport.reportgenerators.ReportGenerator;


public class Main {

    public static void main(String[] args) {

        ReportGenerator reportGenerator = new OutputGenerator();
        reportGenerator.readReport("resources/threat_generator.csv");
        reportGenerator.showReport();

    }
}
