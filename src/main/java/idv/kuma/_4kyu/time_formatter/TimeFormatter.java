package idv.kuma._4kyu.time_formatter;

public class TimeFormatter {

    private static StringBuilder sb;

    public static String formatDuration(int leftover) {
        // your code goes here

        if (0 == leftover) return "now";


        sb = new StringBuilder();

        if (60 <= leftover) {

            int minutes = leftover / 60;
            leftover -= minutes * 60;

            appendSubStrings(minutes, "minute");

            if (1 <= leftover) {
                sb.append(" and ");
            }
        }


        if (1 <= leftover) {
            int seconds = leftover / 1;
            leftover -= seconds * 1;

            appendSubStrings(seconds, "second");

            if (1 <= leftover) {
                sb.append(" and ");
            }
        }

        return sb.toString();
    }

    static void appendSubStrings(int number, String unit) {
        sb.append(number);
        sb.append(" ");
        sb.append(unit);
        sb.append(((number == 1) ? "" : "s"));
    }

}