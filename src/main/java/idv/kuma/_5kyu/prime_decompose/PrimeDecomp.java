package idv.kuma._5kyu.prime_decompose;

import java.util.stream.IntStream;

/**
 * Created by bearhsu2 on 3/25/2018.
 */
public class PrimeDecomp {

    public static String factors(int n) {
        if (n == 1) {
            return "(1)";
        }

        int copy = n;
        StringBuilder sb = new StringBuilder();

        for (int p = 2; p <= n && copy > 1; p++) {
            if (isPrime(p)) {
                int times = 0;
                if (copy % p == 0) {
                    do {
                        copy /= p;
                        times++;
                    } while (copy % p == 0);
                    appendSubstring(sb, p, times);
                }

            }
        }

        return sb.toString();
    }

    public static void appendSubstring(StringBuilder sb, int prime, int times) {
        sb.append("(").append(prime);
        if (times > 1) {
            sb.append("**").append(times);
        }
        sb.append(")");
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }
}