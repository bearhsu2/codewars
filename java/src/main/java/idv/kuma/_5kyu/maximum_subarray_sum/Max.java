package idv.kuma._5kyu.maximum_subarray_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Max {
    public static int sequence(int[] array) {


        new HashMap<Integer, String>(){

        };


        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());

        int n = list.size();

        int max = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j <= n; j++) {

                int sum = list.subList(i, j).stream().mapToInt(Integer::intValue).sum();


                if (sum > max) max = sum;

            }
        }

        return max;
    }
}