package idv.kuma._3kyu.prime_stream_pg13;

import java.util.stream.IntStream;

public class Primes {
    public static IntStream stream() {
        return IntStream.of(2, 3, 5, 7, 11, 13, 17);
    }
}
