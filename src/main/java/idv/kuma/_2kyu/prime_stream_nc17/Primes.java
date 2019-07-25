package idv.kuma._2kyu.prime_stream_nc17;

import java.util.stream.IntStream;

public class Primes {


    public static IntStream stream() {

        IntStream stream1 = IntStream.builder().add(2).build();

        IntStream stream2 = IntStream.iterate(3, i -> i + 2).filter(Primes::isPrime);

        return IntStream.concat(stream1, stream2);

    }


    private static boolean isPrime(int candidate) {

        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);

    }


}
