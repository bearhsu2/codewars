package idv.kuma._4kyu.time_formatter;

public class TimeFormatter {

    private static StringBuilder sb;
    private static int leftover;

    public static String formatDuration(int input) {

        sb = new StringBuilder();
        leftover = input;

        handleWithUnit(3600, "hour");
        handleWithUnit(60, "minute");
        handleWithUnit(1, "second");

        return sb.length() == 0 ? "now" : sb.toString();
    }

    static void handleWithUnit(int unitSizeInSec, String unitName) {
        if (unitSizeInSec <= leftover) {

            int units = leftover / unitSizeInSec;

            leftover -= units * unitSizeInSec;

            appendSubStrings(units, unitName);

            if (stillHaveTime()) {
                sb.append(" and ");
            }
        }
    }

    private static boolean stillHaveTime() {
        return 1 <= leftover;
    }

    static void appendSubStrings(int number, String unit) {
        sb.append(number);
        sb.append(" ");
        sb.append(unit);
        sb.append(((number == 1) ? "" : "s"));
    }

}