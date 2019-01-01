package idv.kuma._2kyu.prime_stream_nc17;

import java.util.stream.IntStream;

public class Primes {


    public static IntStream stream() {

        IntStream stream1 = IntStream.builder().add(2).build();

        IntStream stream2 = IntStream.iterate(3, i -> i + 2);

        return IntStream.concat(stream1, stream2);

    }




}
