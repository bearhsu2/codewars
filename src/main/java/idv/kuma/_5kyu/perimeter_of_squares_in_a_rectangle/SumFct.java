package idv.kuma._5kyu.perimeter_of_squares_in_a_rectangle;


import java.math.BigInteger;

public class SumFct {

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
        return fibonassi(n.subtract(BigInteger.ONE)).add(fibonassi(n.subtract(BigInteger.valueOf(2))));
    }

}