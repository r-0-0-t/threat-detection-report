package com.ishan.tdreport.reportgenerators;

import com.ishan.tdreport.models.Report;

import java.util.*;

import static com.ishan.tdreport.constants.Constants.*;

public class OutputGenerator extends CsvReportGenerator {

    Map<String, Report> reports = new TreeMap<>();

    @Override
    protected void handleRow(String[] row) {
        if(reports.containsKey(row[IP_ADDRESS])) {
            Report r = reports.get(row[IP_ADDRESS]);
            r.setLastUpdated(row[TIMESTAMP]);
            r.setStatus(row[STATUS]);
            r.setCount(r.getCount() + 1);
        }
        else {
            reports.put(
                    row[IP_ADDRESS], new Report(row[IP_ADDRESS], 1, row[TIMESTAMP], row[TIMESTAMP], row[STATUS]));
        }
    }

    @Override
    public void showReport() {
        System.out.println("IP-Address\tThreats count\tLast event time\tStatus\tDifference(Hours & Minutes)");
        reports.forEach((s, report) -> {
            System.out.println(report);
        });
    }
}
