package idv.kuma._6kyu.numericals_of_a_string;

import java.util.HashMap;
import java.util.Map;

public class JomoPipi {

    public static String numericals(String s) {

        Map<Character, Integer> countMap = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        char[] charArray = s.toCharArray();


        for (char c : charArray) {

            Integer count = countMap.get(c);

            if (count == null) {
                count = 1;
                countMap.put(c, count);
            } else {

                count++;
                countMap.put(c, count);
            }

            sb.append(count);
        }

        return sb.toString();

//
//        if (s.equals("abc")) {
//            return "111";
//        }
//
//        return "1112";
    }
}
