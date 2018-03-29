package idv.kuma._4kyu.next_smaller_number_with_the_same_digits;

import java.util.*;

/**
 * Created by bearhsu2 on 3/29/2018.
 */
public class Kata {
    public static long nextSmaller(long n) {
        if (n <= 10) return -1;

        List digits = longToList(n);
        Collections.sort(digits);
        System.out.println("all digits: " + digits);

        List<Long> permutations = findPermutations(digits);

        for(long permutation : permutations){

        }

        return n;

    }

    private static List<Long> findPermutations(List<Integer> digits) {
        List<Long> result = findSubPermutations(digits, 0);
        return result;
    }

    private static List<Long> findSubPermutations(List<Integer> digits, int level) {
        List<Long> result = new ArrayList<>();
        if (digits.size() <= 1) {
            result.add(Long.valueOf(digits.get(0)));
        } else {
            for (int i = 0; i < digits.size(); i++) {
                List<Integer> otherDigits = makeOtherDigits(digits, i);
                List<Long> subPermutations = findSubPermutations(otherDigits, level + 1);

                for (long subPermutation : subPermutations){
                    result.add(mergeResult(digits.get(i), subPermutation));
                }
            }
        }
        return result;
    }

    private static long mergeResult(int lead, long follow){
        return Long.valueOf(lead + String.valueOf(follow));
    }

    private static List<Integer> makeOtherDigits(List<Integer> digits, int indexToExpell) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < digits.size(); i++) {
            if (i != indexToExpell) result.add(digits.get(i));
        }
        return result;
    }

    private static List<Integer> longToList(long n) {
        List<Integer> result = new ArrayList<>();
        while (n > 0) {
            result.add((int) (n % 10));
            n /= 10;
        }
        return result;
    }
}