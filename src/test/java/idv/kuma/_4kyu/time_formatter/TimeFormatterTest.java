package idv.kuma._4kyu.time_formatter;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TimeFormatterTest {


    @Test
    public void Zero() throws Exception {
        assertEquals("now", TimeFormatter.formatDuration(0));
    }

    @Test
    public void One_Second() throws Exception {
        assertEquals("1 second", TimeFormatter.formatDuration(1));
    }

    @Test
    public void Two_Seconds() throws Exception {
        assertEquals("2 seconds", TimeFormatter.formatDuration(2));

    }

    @Test
    public void Three_Seconds() throws Exception {
        assertEquals("3 seconds", TimeFormatter.formatDuration(3));

    }

    @Test
    public void One_Minute() throws Exception {
        assertEquals("1 minute", TimeFormatter.formatDuration(60));

    }

    @Test
    public void One_Minute_One_Second() throws Exception {
        assertEquals("1 minute and 1 second", TimeFormatter.formatDuration(61));

    }

    @Test
    public void Two_Minutes() throws Exception {
        assertEquals("2 minutes", TimeFormatter.formatDuration(120));
    }


    @Test
    public void Two_Minutes_One_Second() throws Exception {
        assertEquals("2 minutes and 1 second", TimeFormatter.formatDuration(121));
    }

    @Test
    public void One_Hour() throws Exception {
        assertEquals("1 hour", TimeFormatter.formatDuration(3600));
    }

    @Test
    public void One_Hour_One_Minute() throws Exception {
        assertEquals("1 hour and 1 minute", TimeFormatter.formatDuration(3660));
    }

    @Test
    public void One_Hour_One_Second() throws Exception {
        assertEquals("1 hour and 1 second", TimeFormatter.formatDuration(3601));
    }

    @Test
    public void One_Hour_One_Min_One_Second() throws Exception {
        assertEquals("1 hour, 1 minute and 1 second", TimeFormatter.formatDuration(3661));
    }

    @Test
    public void One_Day_One_Hour_One_Min_One_Second() throws Exception {
        assertEquals("1 day, 1 hour, 1 minute and 1 second", TimeFormatter.formatDuration(1 + 60 + 3600 + 86400));
    }

    @Test
    public void Two_Day_One_Hour_One_Min_One_Second() throws Exception {
        assertEquals("2 days, 1 hour, 1 minute and 1 second", TimeFormatter.formatDuration(1 + 60 + 3600 + 2 * 86400));
    }

    @Test
    public void One_Year_Two_Day_One_Hour_One_Min_One_Second() throws Exception {
        assertEquals("1 year, 2 days, 1 hour, 1 minute and 1 second", TimeFormatter.formatDuration(1 + 60 + 3600 + 2 * 86400 + 31536000));
    }

    @Ignore
    @Test
    public void testFormatDurationExamples() {
        // Example Test Cases
        assertEquals("1 second", TimeFormatter.formatDuration(1));
        assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62));
        assertEquals("2 minutes", TimeFormatter.formatDuration(120));
        assertEquals("1 hour", TimeFormatter.formatDuration(3600));
        assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatter.formatDuration(3662));
    }
}
