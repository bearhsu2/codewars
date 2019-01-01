package idv.kuma._7kyu.benefactor;

import java.util.Arrays;

public class NewAverage {
    public static long newAvg(double[] arr, double navg) {
        // your code
        int n = arr.length;

        double sum = Arrays.stream(arr).sum();

        double newSum = navg * (n + 1);


        if (newSum <= sum) throw new IllegalArgumentException();

        double diff = newSum - sum;

        long result = (long) Math.ceil(diff);


        return result;
    }
}