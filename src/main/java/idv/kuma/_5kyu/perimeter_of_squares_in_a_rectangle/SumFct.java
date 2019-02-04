package idv.kuma._5kyu.perimeter_of_squares_in_a_rectangle;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SumFct {

    private static Map<BigInteger, BigInteger> nToFibonacci = new HashMap<>();

    static {
        nToFibonacci.put(BigInteger.ZERO, BigInteger.ONE);
        nToFibonacci.put(BigInteger.ONE, BigInteger.ONE);
    }

    // https://www.codewars.com/kata/perimeter-of-squares-in-a-rectangle/train/java
    public static BigInteger perimeter(BigInteger n) {

        BigInteger result = BigInteger.ZERO;

        for (BigInteger i = BigInteger.ZERO; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.add(fibonacci(i));
        }

        return result.multiply(BigInteger.valueOf(4));
    }

    private static BigInteger fibonacci(BigInteger n) {

        BigInteger existing = nToFibonacci.get(n);

        if (!Objects.isNull(existing)) return existing;

        BigInteger value = fibonacci(n.subtract(BigInteger.ONE)).add(fibonacci(n.subtract(BigInteger.valueOf(2))));
        nToFibonacci.put(n, value);

        return value;
    }

}