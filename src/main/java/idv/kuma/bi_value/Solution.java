package idv.kuma.bi_value;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public int solution(int[] inputArray) {
        List<Integer> rawList = Arrays.stream(inputArray).boxed().collect(Collectors.toList());
        int longestLength = 0;

        int totalLength = inputArray.length;
        for (int i = 0; i < totalLength; i++) {
            for (int j = i + longestLength + 1; j <= totalLength; j++) {

                List<Integer> currentSubList = rawList.subList(i, j);

                if (isBiValued(currentSubList)) {

                    int currentLength = currentSubList.size();

                    if (currentLength > longestLength) {
                        longestLength = currentLength;

                        if (i == 0 && j == totalLength) return longestLength;

                    }

                } else {
                    // When a Non-BiValue appears, the rest will be all Non-BiValues
                    break;
                }

            }
        }

        return longestLength;
    }

    private boolean isBiValued(List<Integer> list) {

        return new HashSet<>(list).size() <= 2;
    }


}

