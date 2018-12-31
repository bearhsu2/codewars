package idv.kuma._3kyu.prime_stream_pg13;

import java.util.stream.IntStream;

public class Primes {


    public static IntStream stream() {

        return IntStream.iterate(2, i -> i + 1).filter(Primes::isPrime);

    }

    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }
}
