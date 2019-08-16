package idv.kuma._3kyu.the_millionth_fibonacci_kata;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static Map<BigInteger, BigInteger> nToFibonacci = new HashMap<>();

    static {
        nToFibonacci.put(BigInteger.ONE, BigInteger.ONE);
        nToFibonacci.put(BigInteger.valueOf(2L), BigInteger.ONE);
    }

    public static BigInteger fib(BigInteger n) {

        BigInteger knownFibonacci = nToFibonacci.get(n);

        if (knownFibonacci == null) {

            if (n.signum() == 1) {
                BigInteger calculatedFibonacci = fib(n.subtract(BigInteger.ONE)).add(fib(n.subtract(BigInteger.valueOf(2L))));
                nToFibonacci.put(n, calculatedFibonacci);
                return calculatedFibonacci;
            } else {

                // signum() = 0 or -1

                BigInteger calculatedFibonacci = fib(n.add(BigInteger.valueOf(2L))).subtract(fib(n.add(BigInteger.ONE)));
                nToFibonacci.put(n, calculatedFibonacci);
                return calculatedFibonacci;
            }

        } else {
            return knownFibonacci;
        }

    }

}
