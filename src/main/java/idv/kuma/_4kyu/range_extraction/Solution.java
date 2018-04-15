package idv.kuma._4kyu.range_extraction;

import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public static String rangeExtraction(int[] arr) {
        return printFriendly(arr);
    }

    private static String printFriendly(int[] arrIn) {
        return Arrays.stream(arrIn)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
    }
}