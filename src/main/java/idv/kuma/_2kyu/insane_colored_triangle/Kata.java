package idv.kuma._2kyu.insane_colored_triangle;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;


public class Kata {

    private static Map<Character, Integer> colorToNumber = new HashMap<>();
    private static Map<Integer, Character> numberToColor = new HashMap<>();

    private static Map<BigInteger, BigInteger> knownLevels = new HashMap<>();
    private static Map<Set<BigInteger>, BigInteger> knownCombinations = new HashMap<>();


    private static final BigDecimal EXP = BigDecimal.valueOf(Math.exp(1));


    static {
        colorToNumber.put('R', 0);
        colorToNumber.put('G', 1);
        colorToNumber.put('B', 2);

        numberToColor.put(0, 'R');
        numberToColor.put(1, 'G');
        numberToColor.put(2, 'B');
    }

    // https://www.codewars.com/kata/5a331ea7ee1aae8f24000175/train/java
    public static char triangle(final String row) {

        if (row.length() == 1) {
            return row.charAt(0);
        }

        int n = row.length();

        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numberList.add(colorToNumber.get(Character.valueOf(row.charAt(i))));
        }

        // process here
        // (-1)^(n-1) * sum(k = 1 to n) C(n-1, k-1) * ak
        int sign = (n % 2 == 0) ? -1 : 1;

        BigInteger answer = BigInteger.valueOf(0L);
        for (int k = 1; k <= n; k++) {
            answer = answer.add(combination(n - 1, k - 1).multiply(BigInteger.valueOf(numberList.get(k - 1))));
        }

        answer = answer.multiply(BigInteger.valueOf(sign));

        answer = answer.mod(BigInteger.valueOf(3));


        return numberToColor.get(answer.intValue());

    }

    public static BigInteger combination(int n, int m) {

        Set key = new HashSet<>(Arrays.asList(n, m));
        BigInteger knownCombination = knownCombinations.get(key);
        if (knownCombination != null) {
            return knownCombination;
        }

        if (m == 0 || m == n) {
            knownCombinations.put(key, BigInteger.ONE);
            return BigInteger.ONE;
        }
        ////////////////

        double logSum = sumLog(m + 1, n) - sumLog(2, n - m);
        System.out.printf("log C(%d,%d) = %f\n", n, m, logSum);

        BigInteger combination = BigInteger.valueOf(Math.round(Math.exp(logSum) % 3) % 3);
        System.out.println("combination = " + combination);

        knownCombinations.put(key, combination);

        return combination;


        ////////////////
//
//        BigInteger combination = level(n).divide(level(m)).divide(level(n.subtract(m)));
////        knownCombinations.put(key, combination);
//        System.out.println("");

    }

    private static double sumLog(int k, int n) {

        double result = 0D;

        for (int i = k; i <= n; i++) {
            result += Math.log(i);
        }

        return result;

    }


    public static BigInteger level(BigInteger n) {

        BigInteger knownLevel = knownLevels.get(n);
        if (knownLevel != null) {
            return knownLevel;
        }

        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.multiply(i);
        }

        knownLevels.put(n, result);

        return result;
    }


}