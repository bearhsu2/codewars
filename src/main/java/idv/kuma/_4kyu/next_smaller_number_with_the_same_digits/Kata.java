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

        List digits = longToList(n, String.valueOf(n).length());
        Collections.sort(digits);
        System.out.println("all digits: " + digits);

        List<Long> permutations = findPermutations(digits);

        long result = -1;
        for (long permutation : permutations) {
            if (permutation > result
                    && permutation < n
                    && !isLedByZero(permutation, digits.size())) {
                result = permutation;
            }

            if (permutation >= n) {
                break;
            }
        }
        return result;
    }

    private static boolean isLedByZero(long number, int numDigits) {
        return String.valueOf(number).length() < numDigits;
    }


    private static List<Long> findPermutations(List<Integer> digits) {
        List<Long> result = findSubPermutations(digits, 0);
        return result;
    }

    private static List<Long> findSubPermutations(List<Integer> digits, int level) {

        if (storedPermutations.containsKey(digits)) return storedPermutations.get(digits);

        List<Long> result = new ArrayList<>();
        if (digits.size() <= 1) {
            result.add(Long.valueOf(digits.get(0)));
        } else {
            for (int i = 0; i < digits.size(); i++) {
                List<Integer> otherDigits = makeOtherDigits(digits, i);
                List<Long> subPermutations = findSubPermutations(otherDigits, level + 1);

                for (long subPermutation : subPermutations) {
                    result.add(mergeResult(digits.get(i), subPermutation, digits.size() - 1));
                }
            }
        }

        for (long element : result){
            storedPermutations.put(longToList(element, digits.size()), result);
        }

        return result;
    }

    private static long mergeResult(int lead, long follow, int followDigits) {
        return lead * ((long)Math.pow(10, followDigits)) + follow;
    }

    private static List<Integer> makeOtherDigits(List<Integer> digits, int indexToExpell) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < digits.size(); i++) {
            if (i != indexToExpell) result.add(digits.get(i));
        }
        return result;
    }

    private static List<Integer> longToList(long n, int numDigits) {

        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (n > 0) {
            result.add((int) (n % 10));
            n /= 10;
            i++;
        }

        for(int j = i; j < numDigits; j++){
            result.add(0, 0);
        }
        return result;
    }
}