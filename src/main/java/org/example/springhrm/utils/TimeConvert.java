package org.example.springhrm.utils;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TimeConvert {
    public static Time StringToTime(String timeString) {
        String[] timeSplit = timeString.split(":");
        return  new Time(Integer.parseInt(timeSplit[0]), Integer.parseInt(timeSplit[1]), 0);
    }

    public static float computeDuration(String startTime, String endTime) {
        String[] startTimeList = startTime.split(":");
        String[] endTimeList = endTime.split(":");
        int hours = Math.abs(Integer.parseInt(endTimeList[0]) - Integer.parseInt(startTimeList[0]));
        int minutes = Math.abs(Integer.parseInt(endTimeList[1]) - Integer.parseInt(startTimeList[1]));
        return (float) (hours + (float) minutes / 60);
    }

    public  static int getMonthFromDate(Date date){
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        ZonedDateTime dateTime = ZonedDateTime.parse(date.toString(), inputFormatter);
        String formattedDate = dateTime.format(outputFormatter);
        return Integer.parseInt(formattedDate.split("/")[1]);
    }

    public  static int getYearFromDate(Date date){
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ZonedDateTime dateTime = ZonedDateTime.parse(date.toString(), inputFormatter);
        String formattedDate = dateTime.format(outputFormatter);
        return Integer.parseInt(formattedDate.split("/")[2]);
    }

    public static List<LocalDate> getListDate(LocalDate currentDate) {
        LocalDate endOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth());

        List<LocalDate> dates = new ArrayList<>();

        LocalDate date = currentDate;
        while (!date.isAfter(endOfMonth)) {
            dates.add(date);
            date = date.plusDays(1);
        }
        return dates;
    }
    public static LocalTime convertToTime(String timeStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        try {
            return LocalTime.parse(timeStr, formatter);
        } catch (DateTimeParseException e) {
            System.err.println("Invalid time format: " + timeStr);
            return null; // or throw an exception or handle it as needed
        }
    }
}


