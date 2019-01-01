package idv.kuma._2kyu.prime_stream_nc17;

import java.util.stream.IntStream;

public class Primes {

    private static final int N = 2_000_000_000;

    // true: not prime
    // false: prime
    private static boolean[] SIEVE = new boolean[N + 1];

    static {
        SIEVE[0] = true;
        SIEVE[1] = true;

        for (int i = 2; i * i <= N; i++) {
            if (!SIEVE[i]) {
                for (int j = i; i * j <= N; j++) {
                    SIEVE[i * j] = true;
                }
            }
        }
    }


    public static IntStream stream() {

        IntStream stream1 = IntStream.builder().add(2).build();

        IntStream stream2 = IntStream.iterate(3, i -> i + 2).filter(i -> !SIEVE[i]);

        return IntStream.concat(stream1, stream2);

    }


}
