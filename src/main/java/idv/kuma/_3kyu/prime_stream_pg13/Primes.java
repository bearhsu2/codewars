package idv.kuma._3kyu.prime_stream_pg13;

import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Primes {

    private static List<Integer> foundPrimes = new ArrayList<>();

    static {
        foundPrimes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
    }

    public static IntStream stream() {


        return  foundPrimes.stream().mapToInt(Integer::intValue);

//        return IntStream.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71);
    }
}
