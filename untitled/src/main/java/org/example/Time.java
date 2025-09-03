package org.example;

import org.joda.time.DateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.sql.Date;
import java.util.Scanner;

public class Time {

    public DateTime getTime(){
        DateTime now = DateTime.now();
        System.out.println("Current date and time: "+ now);
        return now;
    }
    public LocalTime askTime(String now){

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        try {
            return LocalTime.parse(now, formato);
        } catch (DateTimeParseException e) {
            System.err.println("Erro ao reconhecer a hora: " + e.getMessage());
            return LocalTime.parse("00:00:00.000", formato);
        }
    }
    public String LondonTime(DateTime time_now){
        String []time_london = String.valueOf(time_now).split("T");
        String []time = time_london[1].split(":");
        int tempo = Integer.parseInt(time[0]);
        String new_hour;

        int london_time = tempo + 4;

        if(london_time>=24){
            london_time -= 24;
            new_hour = london_time + ":"+time[1] + ":"+ time[2];
            if(london_time<10){
                new_hour = "0"+london_time+":"+time[1] + ":"+ time[2];
            }
        }
        else if(london_time<10){
            new_hour = "0"+london_time+":"+time[1] + ":"+ time[2];
        }
        else{
            new_hour = london_time + ":"+time[1] + ":"+ time[2];
        }
        System.out.println("Current Time in London: " + new_hour);
        return new_hour;
    }

    public String ReykjavikTime(DateTime time_now){
        // Current time in Reykjavik
        String []time_reykjavik = String.valueOf(time_now).split("T");
        String []time = time_reykjavik[1].split(":");
        int tempo = Integer.parseInt(time[0]);
        String new_hour;

        int reykjavik_time = tempo + 3;

        if(reykjavik_time>=24){
            reykjavik_time -= 24;
            new_hour = reykjavik_time + ":"+time[1] + ":"+ time[2];
            if(reykjavik_time<10){
                new_hour = "0"+reykjavik_time+":"+time[1] + ":"+ time[2];
            }
        }
        else if(reykjavik_time<10){
            new_hour = "0"+reykjavik_time+":"+time[1] + ":"+ time[2];
        }
        else{
            new_hour = reykjavik_time + ":"+time[1] + ":"+ time[2];
        }

        System.out.println("Current Time in Reykjavik: " + new_hour);
        return new_hour;
    }
}
