package idv.kuma._4kyu.time_formatter;

public class TimeFormatter {

    private static StringBuilder sb;

    public static String formatDuration(int seconds) {
        // your code goes here

        if (0 == seconds) return "now";


        sb = new StringBuilder();

        if (60 <= seconds) {
            if (60 == seconds) {
                sb.append("1 minute");
            } else if (61 == seconds) {
                sb.append("1 minute and 1 second");
            }

            return sb.toString();

        } else {

            String result = makeSecondString(seconds);
            return result;
        }

    }

    private static String makeSecondString(int seconds) {
        return seconds + " " + "second" + ((seconds ==  1) ? "" : "s");
    }
}