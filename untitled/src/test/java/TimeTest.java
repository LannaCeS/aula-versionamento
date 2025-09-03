import org.example.Time;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static org.junit.Assert.*;

public class TimeTest {
    @Test
    public void getTimeTest(){
        Time tempo = new Time();
        DateTime time = tempo.getTime();
        DateTime now = DateTime.now();

        //comparando os tempos sem considerar os milissegundos
        String []tempos = String.valueOf(time).split("\\."); //array do tempo calculado pela classe
        String []agora = String.valueOf(now).split("\\."); //array do tempo base
        assertEquals(agora[0], tempos[0]);
    }

    @Test
    public void askTimeOkayTest(){
        Time tempo = new Time();
        String time = "20:26:15.000";
        LocalTime times = tempo.askTime(time);
        LocalTime zero = LocalTime.parse("00:00:00.000", DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
        assertNotEquals(zero, times);
    }

    @Test
    public void askTimeNotOkayTest(){
        Time tempo = new Time();
        String time = "a";
        LocalTime times = tempo.askTime(time);
        LocalTime zero = LocalTime.parse("00:00:00.000", DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
        assertEquals(zero, times);
    }

    @Test
    public void LondonTimeTest(){
        Time tempo = new Time();
        DateTime time = DateTime.now();
        String timeLon = tempo.LondonTime(time);
        DateTime dtInLondon = new DateTime(DateTimeZone.forID("Europe/London"));

        //comparando os tempos sem considerar os milissegundos
        String []tempo_lon = String.valueOf(timeLon).split("\\."); //array do tempo calculado pela classe
        String []lon = String.valueOf(dtInLondon).split("\\."); //array do tempo base
        String []london = lon[0].split("T");
        assertEquals(london[1], tempo_lon[0]);
    }

    @Test
    public void ReykjavikTimeTest(){
        Time tempo = new Time();
        DateTime time = DateTime.now();
        String timeRey = tempo.ReykjavikTime(time);
        DateTime dtInReykjavik = time.withZone(DateTimeZone.forID("Atlantic/Reykjavik"));
        //comparando os tempos sem considerar os milissegundos
        String []tempo_rey = String.valueOf(timeRey).split("\\."); //array do tempo calculado pela classe
        String []rey = String.valueOf(dtInReykjavik).split("\\."); //array do tempo base
        String []reykjavik = rey[0].split("T");
        assertEquals(reykjavik[1], tempo_rey[0]);
    }
}
