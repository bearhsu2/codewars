package idv.kuma._4kyu.range_extraction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public static String rangeExtraction(int[] arr) {
        List<List<Integer>> processed = doProcess(arr);
        return printFriendly(processed);
    }

    static List<List<Integer>> doProcess(int[] rawData) {

        List<List<Integer>> result = new ArrayList<>();

        int length = rawData.length;
        for (int i = 0; i < length; ) {
            List<Integer> subList = new ArrayList<>();
            subList.add(rawData[i]);
            int j = i + 1;
            while (j < length && rawData[j] == rawData[j - 1] + 1) {
                subList.add(rawData[j]);
                j++;
            }
            result.add(subList);
            i = j;
        }
        return result;
    }

    private static String printFriendly(List<List<Integer>> processed) {

        StringBuilder sb = new StringBuilder();
        for (List<Integer> subList : processed){
            sb.append(toSubString(subList)).append(",");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private static String toSubString(List<Integer> subList) {
        if (subList.size() >= 3){
            return subList.get(0) + "-" + subList.get(subList.size() - 1);
        } else {
            return subList.stream().map(Object::toString).collect(Collectors.joining(","));
        }
    }
}