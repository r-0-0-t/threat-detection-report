package com.ishan.tdreport.models;

import com.ishan.tdreport.helpers.DateTimeHelper;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static com.ishan.tdreport.constants.Constants.DEFAULT_DATE_TIME_FORMAT;

public class Report {
    private String ip;
    private long count;
    private String createdAt;
    private String lastUpdated;
    private String status;

    public Report(String ip, long count, String createdAt, String lastUpdated, String status) {
        this.ip = ip;
        this.count = count;
        this.createdAt = createdAt;
        this.lastUpdated = lastUpdated;
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String timeDuration = calculateTimeDuration();
        return String.format("%s\t%d\t%s\t%s\t%s\t", ip, count, lastUpdated, status.equals("True") ? "Safe" : "Infected", timeDuration);
    }

    private String calculateTimeDuration() {

        LocalDateTime fromTime = DateTimeHelper.getInstance().getDateTime(createdAt);
        LocalDateTime toTime = DateTimeHelper.getInstance().getDateTime(lastUpdated);

        LocalDateTime tempTime = LocalDateTime.from(fromTime);
        long hours = tempTime.until( toTime, ChronoUnit.HOURS );
        tempTime = tempTime.plusHours(hours);
        long minutes = tempTime.until( toTime, ChronoUnit.MINUTES);
        tempTime = tempTime.plusMinutes(minutes);

        String timeDuration = hours + " hour " + minutes + " minutes";
        return timeDuration;
    }

}
