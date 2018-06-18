package idv.kuma._4kyu.time_formatter;

public class TimeFormatter {

    private static StringBuilder sb;
    private static int leftover;

    public static String formatDuration(int input) {
        // your code goes here

        if (0 == input) return "now";

        sb = new StringBuilder();
        leftover = input;

        handleWithUnit(60, "minute");

        handleWithUnit(1, "second");

        return sb.toString();
    }

    static void handleWithUnit(int unitSizeInSec, String unitName) {
        if (unitSizeInSec <= leftover) {

            int units = leftover / unitSizeInSec;
            leftover -= units * unitSizeInSec;

            appendSubStrings(units, unitName);

            if (1 <= leftover) {
                sb.append(" and ");
            }
        }
    }

    static void appendSubStrings(int number, String unit) {
        sb.append(number);
        sb.append(" ");
        sb.append(unit);
        sb.append(((number == 1) ? "" : "s"));
    }

}