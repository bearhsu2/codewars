package idv.kuma._2kyu.insane_colored_triangle;



import java.math.BigInteger;
import java.util.*;


public class Kata {

    private static Map<Character, BigInteger> colorToNumber = new HashMap<>();
    private static Map<BigInteger, Character> numberToColor = new HashMap<>();

    private static Map<BigInteger, BigInteger> knownLevels = new HashMap<>();
    private static Map<Set<BigInteger>, BigInteger> knownCombinations = new HashMap<>();


    static {
        colorToNumber.put('R', BigInteger.valueOf(0L));
        colorToNumber.put('G', BigInteger.valueOf(1L));
        colorToNumber.put('B', BigInteger.valueOf(2L));

        numberToColor.put(BigInteger.valueOf(0L), 'R');
        numberToColor.put(BigInteger.valueOf(1L), 'G');
        numberToColor.put(BigInteger.valueOf(2L), 'B');
    }

    // https://www.codewars.com/kata/5a331ea7ee1aae8f24000175/train/java
    public static char triangle(final String row) {

        if (row.length() == 1) {
            return row.charAt(0);
        }

        int n = row.length();

        List<BigInteger> numberList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numberList.add(colorToNumber.get(Character.valueOf(row.charAt(i))));
        }

        // process here
        // (-1)^(n-1) * sum(k = 1 to n) C(n-1, k-1) * ak
        int sign = (n % 2 == 0) ? -1 : 1;

        BigInteger answer = BigInteger.valueOf(0L);
        for (int k = 1; k <= n; k++) {
            answer = answer.add(combination(BigInteger.valueOf(n - 1), BigInteger.valueOf(k - 1)).multiply(numberList.get(k - 1)));
        }

        answer = answer.multiply(BigInteger.valueOf(sign));

        answer = answer.mod(BigInteger.valueOf(3));


        return numberToColor.get(answer);

    }

    public static BigInteger combination(BigInteger n, BigInteger m) {

        Set key = new HashSet<>(Arrays.asList(n, m));
        BigInteger knownCombination = knownCombinations.get(key);
        if (knownCombination != null){
            return knownCombination;
        }


        if (m.equals(BigInteger.ZERO) || m.equals(n)){
            knownCombinations.put(key, BigInteger.ONE);
            return BigInteger.ONE;
        }

        BigInteger combination = level(n).divide(level(m)).divide(level(n.subtract(m)));
        knownCombinations.put(key, combination);

        return combination;
    }

    public static BigInteger level(BigInteger n) {

        BigInteger knownLevel = knownLevels.get(n);
        if (knownLevel != null){
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