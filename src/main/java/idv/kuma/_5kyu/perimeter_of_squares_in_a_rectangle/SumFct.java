package idv.kuma._5kyu.perimeter_of_squares_in_a_rectangle;


import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class SumFct {

    private static Map<BigInteger, BigInteger> nToFibonassi = new HashMap<>();

    static {
        nToFibonassi.put(BigInteger.ZERO, BigInteger.ONE);
        nToFibonassi.put(BigInteger.ONE, BigInteger.ONE);

    }

    // https://www.codewars.com/kata/perimeter-of-squares-in-a-rectangle/train/java
    public static BigInteger perimeter(BigInteger n) {

        BigInteger result = BigInteger.ZERO;

        for (BigInteger i = BigInteger.ZERO; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            BigInteger f = fibonassi(i);
            result = result.add(f);
        }

        return result.multiply(BigInteger.valueOf(4));
    }

    private static BigInteger fibonassi(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) return BigInteger.ONE;
        if (n.equals(BigInteger.ONE)) return BigInteger.ONE;

        if (nToFibonassi.containsKey(n)) return nToFibonassi.get(n);

        BigInteger value = fibonassi(n.subtract(BigInteger.ONE)).add(fibonassi(n.subtract(BigInteger.valueOf(2))));
        nToFibonassi.put(n, value);

        return value;
    }

}