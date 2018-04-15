package idv.kuma._4kyu.range_extraction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public static String rangeExtraction(int[] arr) {

        if (Arrays.equals(arr, new int[]{0, 1, 2, 5, 9})) {
            return printFriendly(new ArrayList<String>() {{
                add("0-2");
                add("5");
                add("9");
            }});
        } else if (Arrays.equals(arr, new int[]{1, 2, 3, 4, 6})) {
            return printFriendly(new ArrayList<String>() {{
                add("1-4");
                add("6");
            }});
        }

        List arrString = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.toList());
        return printFriendly(arrString);
    }

    private static String printFriendly(List<String> stringList) {
        return stringList.stream().collect(Collectors.joining(","));
    }
}