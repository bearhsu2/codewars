package idv.kuma._4kyu.next_smaller_number_with_the_same_digits;

import java.util.*;

/**
 * Created by bearhsu2 on 3/29/2018.
 */
public class Kata {

    private static Map<List<Integer>, List<Long>> storedPermutations = new HashMap<>();

    public static long nextSmaller(long n) {

        System.out.println("n = " + n);
        if (n <= 10) return -1;

        List<Integer> originals = longToList(n);
        List<Integer> results = new ArrayList<>();
        int numDigits = originals.size();

        System.out.println("all digits: " + originals);

        // find first digit that makes stops a "<<<" tail
        int badDigit = -1;
        for (int i = numDigits - 1; i > 0; i--) {
            if (originals.get(i - 1) > originals.get(i)) {
                Collections.swap(originals, i - 1, originals.size() - 1);
                badDigit = i;
                break;
            }
        }

        originals.subList(badDigit, numDigits).sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        if (badDigit == -1) return -1;


        return originals.get(0) == 0 ? -1 : listToLong(originals);
    }

    private static long listToLong(List<Integer> digits) {
        long result = 0L;
        for (int digit : digits) {
            result = result * 10 + digit;
        }
        return result;
    }


    private static List<Integer> longToList(long n) {

        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (n > 0) {
            result.add(0, (int) (n % 10));
            n /= 10;
            i++;
        }
        return result;
    }
}