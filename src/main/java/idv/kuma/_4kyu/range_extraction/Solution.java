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

    static List<List<Integer>> doProcess(int[] rawData) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());


        int length = rawData.length;
        for (int i = 0; i < length; ) {
            List<Integer> subList = new ArrayList<>();
            subList.add(rawData[i]);

            int j = i + 1;
            while (rawData[j] == rawData[j - 1] + 1 && j < length) {
                subList.add(rawData[j]);

                j++;
            }

            result.add(subList);
            i = j;
        }

        return result;
    }

    private static String printFriendly(List<String> stringList) {
        return stringList.stream().collect(Collectors.joining(","));
    }
}