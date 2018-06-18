package idv.kuma._4kyu.time_formatter;

public class TimeFormatter {

    private static StringBuilder sb;

    public static String formatDuration(int seconds) {
        // your code goes here

        if (0 == seconds) return "now";


        sb = new StringBuilder();

        if (60 <= seconds) {

            int minutes = 1;

            sb.append(minutes);
            sb.append(" ");
            sb.append("minute");
            sb.append(((minutes == 1) ? "" : "s"));

            if (61 <= seconds){
                seconds -= 60;
                sb.append(" and ");

                sb.append(seconds);
                sb.append(" ");
                sb.append("second");
                sb.append(((seconds == 1) ? "" : "s"));
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