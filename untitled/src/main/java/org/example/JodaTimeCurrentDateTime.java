package org.example;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class JodaTimeCurrentDateTime {
    public static void main(String[] args) {

        Time tempo = new Time();

        // Get current time and date
        DateTime date = tempo.getTime();
        System.out.println("Current time and date: "+ date);

        // Ask for current time
        try {
            Scanner info = new Scanner(System.in);
            String now = info.nextLine();
            java.time.LocalTime time = tempo.askTime(now);
        }catch (DateTimeParseException e){
            System.err.println("Erro ao reconhecer a hora.");
        }

        // Get current time
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current LocalTime: " + currentTime);

        // Current time in London
        tempo.LondonTime(date);

        // Current time in Reykjavik
        tempo.ReykjavikTime(date);
    }
}