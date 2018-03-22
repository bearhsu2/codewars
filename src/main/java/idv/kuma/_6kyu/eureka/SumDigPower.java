package idv.kuma._6kyu.eureka;

import java.util.*;

public class SumDigPower {

    private static Set<Long> knownDigPows = new HashSet<>();

    public static List<Long> sumDigPow(long a, long b) {
        List<Long> result = new ArrayList<>();

        for (long i = a; i <= b; i++){
            if (knownDigPows.contains(i)){
                result.add(i);
            } else {
                if (isDigPows(i)){
                    result.add(i);
                    knownDigPows.add(i);
                }
            }
        }

        return result;
    }

    private static boolean isDigPows(long numberIn){
        if (0 >= numberIn) return false;

        long number = numberIn;
        List<Long> digits = new ArrayList<>();

        while (number >= 1){
            digits.add(number % 10);
            number = number / 10;
        }

        long sum = 0;
        int numDigits = digits.size();
        for (int i = 0; i < numDigits; i ++){
            sum += Math.pow(digits.get(i), numDigits - i);
        }

        return sum == numberIn;

    }
}
