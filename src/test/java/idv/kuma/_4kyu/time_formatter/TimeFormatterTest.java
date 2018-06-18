package idv.kuma._4kyu.time_formatter;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TimeFormatterTest {

    @Test
    public void Second_One() throws Exception {
        assertEquals("1 second", TimeFormatter.formatDuration(1));
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
