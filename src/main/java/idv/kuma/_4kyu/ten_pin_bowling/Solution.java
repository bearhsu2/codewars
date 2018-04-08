package idv.kuma._4kyu.ten_pin_bowling;

public class Solution {
    public static int bowling_score(String rawData) {

        int totalScore = 0;

        String[] frames = rawData.split(" ");

        for (int i = 0; i < frames.length; i++) {
            totalScore += handleFrame(i, frames);
        }

        System.out.println("===============================");
        System.out.println("Total = " + totalScore);
        System.out.println("============================================");
        return totalScore;

    }

    public static int handleFrame(int idx, String[] frames) {
        System.out.println("===============================");

        String frame = frames[idx];

        if ("X".equalsIgnoreCase(frame)) {
            System.out.println("Frame " + idx + " is strike: X");
            return handleFrameStrike(idx, frames);
        }

        if (frame.endsWith("/")) {
            System.out.println("Frame " + idx + " is spare: " + frame);
            return handleFrameSpare(idx, frames);
        }

        if (idx >= 9) {
            System.out.println("Frame " + idx + " is last frame: " + frame);
            return handleLastFrame(frame);
        }

        // oridinary frame
        System.out.println("Frame " + idx + " is ordinary frame: " + frame);
        return handleFrameOrdinary(frame);

    }

    public static int handleLastFrame(String frame) {
        int result = 0;

        char[] charArray = frame.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            result += getRollRawScore(i == 0 ? '0' : charArray[i - 1], charArray[i]);
            System.out.println("roll #" + i + ". Result = " + result);
        }

        System.out.println("Result = " + result);
        return result;
    }

    public static int handleFrameStrike(int idx, String[] frames) {
        int result = 10;

        int calculatedRolls = 0;

        int nextIdx = idx;
        while (calculatedRolls < 2) {
            nextIdx++;
            char[] nextCharArray = frames[nextIdx].toCharArray();

            for (int i = 0; i < nextCharArray.length; i++) {
                if (calculatedRolls >= 2) break;
                result += getRollRawScore(i == 0 ? '0' : nextCharArray[i - 1], nextCharArray[i]);
                calculatedRolls++;
                System.out.println("Calculated rolls = " + calculatedRolls + ". Result = " + result);
            }
        }

        System.out.println("Result = " + result);
        return result;
    }

    public static int handleFrameSpare(int idx, String[] frames) {
        int result = 10;

        int nextIdx = idx + 1;
        char[] nextCharArray = frames[nextIdx].toCharArray();

        result += getRollRawScore('0', nextCharArray[0]);

        System.out.println("Result = " + result);
        return result;
    }


    public static int getRollRawScore(char prevChar, char currChar) {
        if (currChar == 'X') return 10;
        if (currChar == '/') return 10 - Character.getNumericValue(prevChar);
        return Character.getNumericValue(currChar);

    }

    public static int handleFrameOrdinary(String frame) {

        int result = 0;
        char[] chars = frame.toCharArray();
        for (char c : chars) {
            result += Character.getNumericValue(c);
        }

        System.out.println("Result = " + result);
        return result;

    }
}