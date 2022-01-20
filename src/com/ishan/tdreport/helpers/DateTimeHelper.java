package com.ishan.tdreport.helpers;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.ishan.tdreport.constants.Constants.DEFAULT_DATE_TIME_FORMAT;

public class DateTimeHelper {

    private static DateTimeHelper dateTimeHelper;
    private  DateTimeFormatter formatter;

    private DateTimeHelper() {
        formatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT);
    }

    public static DateTimeHelper getInstance() {
        if(dateTimeHelper != null) {
            return dateTimeHelper;
        }
        return dateTimeHelper = new DateTimeHelper();
    }

    public LocalDateTime getDateTime(String dateTime)
    {
        return LocalDateTime.parse(dateTime, this.formatter);
    }
    public LocalDateTime getDateTime(String dateTime, DateTimeFormatter format) throws DateTimeException
    {
        return LocalDateTime.parse(dateTime, format);
    }

}
