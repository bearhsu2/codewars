package idv.kuma._7kyu.coloured_triangles;

import java.util.HashMap;
import java.util.Map;

public class Kata {

    private static Map<String, Character> knownAnswers = new HashMap<>();

    static {

        knownAnswers.put("R", 'R');
        knownAnswers.put("G", 'G');
        knownAnswers.put("B", 'B');
        knownAnswers.put("RR", 'R');
        knownAnswers.put("GG", 'G');
        knownAnswers.put("BB", 'B');
        knownAnswers.put("RG", 'B');
        knownAnswers.put("GR", 'B');
        knownAnswers.put("RB", 'G');
        knownAnswers.put("BR", 'G');
        knownAnswers.put("BG", 'R');
        knownAnswers.put("GB", 'R');

    }

    // https://www.codewars.com/kata/5a331ea7ee1aae8f24000175/train/java
    public static char triangle(final String row) {

        Character known = knownAnswers.get(row);

        if (null != known) {
            return known;
        }

        String nextLevelString = findNextLevelString(row);
        return triangle(nextLevelString);

    }

    private static String findNextLevelString(String row) {

        char[] chars = row.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length - 1; i++) {
            sb.append(knownAnswers.get(row.substring(i, i + 2)));
        }

        return sb.toString();

    }


}