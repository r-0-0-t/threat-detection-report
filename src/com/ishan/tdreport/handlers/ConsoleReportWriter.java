package com.ishan.tdreport.handlers;

import com.ishan.tdreport.models.Report;

import java.util.*;

import static com.ishan.tdreport.constants.Constants.*;

public class ConsoleReportWriter implements ReportWriter {

    public ConsoleReportWriter() {
    }

    Map<String, Report> reports = new TreeMap<>();

    public  void handleRow(String[] row) {
        if(reports.containsKey(row[IP_ADDRESS])) {
            Report report = reports.get(row[IP_ADDRESS]);
            report.setLastUpdated(row[TIMESTAMP]);
            report.setStatus(row[STATUS]);
            report.setCount(report.getCount() + 1);
        }
        else {
            reports.put(
                    row[IP_ADDRESS], new Report(row[IP_ADDRESS], 1, row[TIMESTAMP], row[TIMESTAMP], row[STATUS]));
        }
    }

    public void showOutput() {
        System.out.println("IP-Address\tThreats count\tLast event time\tStatus\tDifference(Hours & Minutes)");
        reports.forEach((s, report) -> {
            System.out.println(report);
        });
    }
}
