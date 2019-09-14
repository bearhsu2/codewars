package idv.kuma._4kyu.next_smaller_number_with_the_same_digits;

import java.util.*;

/**
 * Created by bearhsu2 on 3/29/2018.
 */
public class Kata {

    public static long nextSmaller(long n) {

        System.out.println("n = " + n);
        if (n <= 10) return -1;

        List<Integer> originals = longToList(n);
        int numDigits = originals.size();

        System.out.println("all digits: " + originals);

        // find first digit that makes stops a "<<<" tail
        int badDigit = -1;
        for (int i = numDigits - 1; i > 0; i--) {
            if (originals.get(i - 1) > originals.get(i)) {

                int j = findLargestButLessThan(originals.subList(i, numDigits), originals.get(i - 1));
                if (j < 0) return -1;

                j += i;
                Collections.swap(originals, i - 1, j);

                badDigit = i;
                break;
            }
        }

        if (badDigit == -1) return -1;

        originals.subList(badDigit, numDigits).sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });


        return originals.get(0) == 0 ? -1 : listToLong(originals);
    }

    private static int findLargestButLessThan(List<Integer> list, int target) {
        int largest = -1;
        int result = -1;
        for (int i = 0; i < list.size(); i++){
            int element = list.get(i);
            if (element > largest && element < target){
                largest = element;
                result = i;
            }
        }
        return result;
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
        while (n > 0) {
            result.add(0, (int) (n % 10));
            n /= 10;
        }
        return result;
    }
}