package org.example;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class JodaTimeCurrentDateTime {
    public static void main(String[] args) {
        // Get current date and time with time zone
        DateTime now = DateTime.now();
        System.out.println("Current DateTime: " + now);

        // Get current date
        LocalDate today = LocalDate.now();
        System.out.println("Current LocalDate: " + today);

        // Get current time
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current LocalTime: " + currentTime);

        // Current time in London
        String []time_london = String.valueOf(currentTime).split(":");
        int hour = Integer.parseInt(time_london[0]);
        int london_time = hour + 4;

        if(london_time>=24){
            london_time -= 24;
        }

        String new_hour = String.valueOf(london_time) + ":"+time_london[1] + ":"+ time_london[2];
        System.out.println("Current Time in London: " + new_hour);
    }
}