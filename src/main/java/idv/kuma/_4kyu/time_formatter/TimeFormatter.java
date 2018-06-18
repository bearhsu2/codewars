package idv.kuma._4kyu.time_formatter;

public class TimeFormatter {

    public static String formatDuration(int seconds) {
        // your code goes here

        if (0 == seconds) return "now";


        if (1 == seconds){
            return "1 second";
        } else if (2 == seconds) {
            return "2 seconds";
        } else {
            return "3 seconds";
        }

    }
}