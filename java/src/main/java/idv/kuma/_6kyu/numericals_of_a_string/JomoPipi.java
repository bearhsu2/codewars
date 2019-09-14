package idv.kuma._6kyu.numericals_of_a_string;

import java.util.HashMap;
import java.util.Map;

public class JomoPipi {

    public static String numericals(String s) {


        return countChars(s.toCharArray()).toString();

    }

    private static StringBuilder countChars(char[] charArray) {

        Map<Character, Integer> countMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {

            Integer count = countMap.getOrDefault(c, 0);

            countMap.put(c, ++count);

            sb.append(count);
        }
        return sb;
    }
}
