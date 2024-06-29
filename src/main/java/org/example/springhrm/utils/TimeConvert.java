package org.example.springhrm.utils;

import java.sql.Time;

public class TimeConvert {
    public static Time StringToTime(String timeString) {
        String[] timeSplit = timeString.split(":");
        Time timeTransfer = new Time(Integer.parseInt(timeSplit[0]), Integer.parseInt(timeSplit[1]), 0);
        return timeTransfer;
    }

    public static float computeDuration(String startTime, String endTime) {
        String[] startTimeList = startTime.split(":");
        String[] endTimeList = endTime.split(":");
        int hours = Math.abs(Integer.parseInt(endTimeList[0]) - Integer.parseInt(startTimeList[0]));
        int minutes = Math.abs(Integer.parseInt(endTimeList[1]) - Integer.parseInt(startTimeList[1]));
        float durationRealTime = (float) (hours + (float) minutes / 60);
        return durationRealTime;
    }
}


