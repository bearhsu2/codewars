package idv.kuma._4kyu.ten_pin_bowling;

public class Solution {
    public static int bowling_score(String rawData) {

        int totalScore = 0;

        String[] frames = rawData.split(" ");

        for (int i = 0; i < frames.length; i++) {

            totalScore += handleFrame(i, frames);

        }

        return totalScore;
    }

    public static int handleFrame(int idx, String[] frames) {

        String frame = frames[idx];

        if ("X".equalsIgnoreCase(frame)) {
            return handleFrameStrike(idx, frames);
        }

        if (frame.endsWith("/")) {
            return 0;
        }

        if (idx >= 10) {
            // TODO: 10th frame, special form
            return 0;
        }

        // oridinary frame
        return handleFrameOrdinary(frame);

    }

    public static int handleFrameStrike(int idx, String[] frames){
        return 0;
    }

    public static int handleFrameOrdinary(String frame) {

        int result = 0;
        char[] chars = frame.toCharArray();
        for (char c : chars) {
            result += Character.getNumericValue(c);
        }
        return result;

    }
}