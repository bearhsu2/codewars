package idv.kuma._4kyu.time_formatter;

public class TimeFormatter {

    private static StringBuilder sb;

    public static String formatDuration(int leftover) {
        // your code goes here

        if (0 == leftover) return "now";


        sb = new StringBuilder();

        if (60 <= leftover) {

            int minutes = 1;

            appendSubStrings(minutes, "minute");

            if (61 <= leftover){

                leftover -= 60;
                sb.append(" and ");

                appendSubStrings(leftover, "second");
            }
        } else {
            appendSubStrings(leftover, "second");
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