package idv.kuma._3kyu.prime_stream_pg13;

import java.util.stream.IntStream;

public class Primes {


    public static IntStream stream() {

        IntStream stream1 = IntStream.builder().add(2).build();

        IntStream stream2 = IntStream.iterate(3, i -> i + 2).filter(Primes::isPrime);

        return IntStream.concat(stream1, stream2);

    }


    private static boolean isPrime(int n) {
        // Corner cases
        if (n <= 1)
            return false;
        if (n == 2 || n == 3)
            return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;

    }

}
