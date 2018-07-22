package idv.kuma._2kyu.insane_colored_triangle;


import java.math.BigDecimal;
import java.util.*;

//https://stackoverflow.com/questions/10118137/fast-n-choose-k-mod-p-for-large-n

public class Kata {

    private static Map<Character, Long> colorToNumber = new HashMap<>();
    private static Map<Long, Character> numberToColor = new HashMap<>();

    private static Map<Set<Long>, Long> knownCombinations = new HashMap<>();

    static {
        colorToNumber.put('R', 0L);
        colorToNumber.put('G', 1L);
        colorToNumber.put('B', 2L);

        numberToColor.put(0L, 'R');
        numberToColor.put(1L, 'G');
        numberToColor.put(2L, 'B');
    }

    // https://www.codewars.com/kata/5a331ea7ee1aae8f24000175/train/java
    public static char triangle(final String row) {

        if (row.length() == 1) {
            return row.charAt(0);
        }

        int n = row.length();

        List<Long> numberList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numberList.add(colorToNumber.get(Character.valueOf(row.charAt(i))));
        }

        // process here
        // (-1)^(n-1) * sum(k = 1 to n) C(n-1, k-1) * ak
        int sign = (n % 2 == 0) ? -1 : 1;

        long answer = 0L;
        for (int k = 1; k <= n; k++) {
            long a = numberList.get(k - 1);
            if (a != 0) {
                answer += combination(n - 1, k - 1, 3L) * a;
            }
        }

        answer *= sign;
        answer = answer % 3L;

        if (answer < 0){
            answer += 3L;
        }


        return numberToColor.get(answer);

    }

    public static long combination(long n, long k, long p) {

        Set key = new HashSet<>(Arrays.asList(n, k));
        Long knownCombination = knownCombinations.get(key);
        if (knownCombination != null) {
            return knownCombination;
        }

        if (k == 0 || k == n) {
            knownCombinations.put(key, 1L);
            return 1L;
        }
        ////////////////

        int num_degree = get_degree(n, p) - get_degree(n - k, p);
        int den_degree = get_degree(k, p);

        if (num_degree > den_degree) {
            return 0L;
        }

        long res = 1;
        for (long i = n; i > n - k; --i) {
            long ti = i;
            while (ti % p == 0) {
                ti /= p;
            }
            res = (res * ti) % p;
        }

        long denom = 1L;
        for (long i = 1; i <= k; ++i) {
            long ti = i;
            while (ti % p == 0) {
                ti /= p;
            }
            denom = (denom * ti) % p;
        }
        res = (res * degree(denom, p - 2, p)) % p;


        knownCombinations.put(key, res);
        return res;


    }

    static int get_degree(long n, long p) { // returns the degree with which p is in n!
        int degree_num = 0;
        long u = p;
        long temp = n;

        while (u <= temp) {
            degree_num += temp / u;
            u *= p;
        }
        return degree_num;
    }

    static long degree( long a,  long k,  long p) {
        long res = 1;
        long cur = a;

        while (k > 0) {
            if (k % 2 > 0) {
                res = (res * cur) % p;
            }
            k /= 2;
            cur = (cur * cur) % p;
        }
        return res;
    }


}