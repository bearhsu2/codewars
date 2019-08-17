package idv.kuma._3kyu.the_millionth_fibonacci_kata;

import java.math.BigDecimal;
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
                return mathWay(n);
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

    public static BigInteger mathWay(BigInteger bigN) {

        // https://www.math.hmc.edu/funfacts/ffiles/10002.4-5.shtml
        int n = bigN.intValue();

        BigDecimal sqrtFive = BigDecimal.valueOf(Math.sqrt(5));



        BigDecimal bigPhy = BigDecimal.ONE.add(sqrtFive).divide(BigDecimal.valueOf(2));
        BigDecimal smallPhy = BigDecimal.ONE.subtract(sqrtFive).divide(BigDecimal.valueOf(2));


        BigDecimal value = bigPhy.pow(n).subtract(smallPhy.pow(n)).divide(sqrtFive);

        BigInteger bigIntegerValue = value.toBigInteger();

        System.out.println(value);
        System.out.println(bigIntegerValue);

        return bigIntegerValue;

    }

}
