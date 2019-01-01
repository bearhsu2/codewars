package idv.kuma._7kyu.benefactor;

import java.util.Arrays;

public class NewAverage {
    public static long newAvg(double[] arr, double navg) {
        // your code

        double sum = Arrays.stream(arr).sum();

        double newSum = navg * (arr.length + 1);

        double result = newSum - sum;

        if (result <= 0) throw new IllegalArgumentException();

        return (long) Math.ceil(result);
    }
}