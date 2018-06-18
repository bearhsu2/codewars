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

        } else {

            sb.append(seconds);
            sb.append(" ");
            sb.append("second");
            sb.append(((seconds == 1) ? "" : "s"));
        }

        return sb.toString();
    }

}