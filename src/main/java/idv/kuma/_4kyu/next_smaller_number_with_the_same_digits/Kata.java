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
        List<Integer> candidates = longToList(n);
        List<Integer> results = new ArrayList<>();
        int numDigits = originals.size();
        Collections.sort(candidates, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println("all digits: " + originals);

        for (int i = 0; i < numDigits; i++) {

            int original = originals.get(i);
            int numCandidates = candidates.size();
            int indexOfOriginal = candidates.indexOf(original);

            boolean found = false;
            for (int j = indexOfOriginal + 1; j < numCandidates; j++) {
                int candidate = candidates.get(j);
                if (candidate < original) {
                    candidates.remove(j);
                    results.add(candidate);
                    found = true;
                    break;
                }
            }
            if (found) {
                results.addAll(candidates);
                break;
            } else {
                candidates.remove(indexOfOriginal);
                results.add(original);
            }
        }


        return results.get(0) == 0 ? -1 : listToLong(results);
    }

    private static long listToLong(List<Integer> digits){
        long result = 0L;
        for (int digit : digits){
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