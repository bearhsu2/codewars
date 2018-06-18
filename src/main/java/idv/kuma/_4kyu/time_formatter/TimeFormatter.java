package idv.kuma._4kyu.time_formatter;

public class TimeFormatter {

    public static String formatDuration(int seconds) {
        // your code goes here

        if (0 == seconds) return "now";


        String result = makeSecondString(seconds);


        return result;

    }

    private static String makeSecondString(int seconds) {
        return seconds + " " + "second" + ((seconds ==  1) ? "" : "s");
    }
}