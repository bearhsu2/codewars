package idv.kuma.lie_strictly;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int[] A) {
        if (isEmptyOrSingleton(A)) {
            return -1;
        }

        return findFarestAdjacentDist(A);

    }

    boolean isEmptyOrSingleton(int[] A) {
        return A.length <= 1;
    }

    private int findFarestAdjacentDist(int[] array) {

        Set<Integer> valueSet = Arrays
                .stream(array)
                .boxed()
                .collect(Collectors.toSet());


        int length = array.length;


        for (int i = 0; i < length; i++) {

            for (int j = length - 1; j > i; j--) {

                if (isAdjacent(array[i], array[j], valueSet)) {

                    // This is the "LONGEST" distance. No need to continue
                    return j - i;

                }
            }

        }
        return -1;

    }


    private boolean isAdjacent(int value1, int value2, Set<Integer> valueSet) {


        return value1 != value2
                && valueSet
                .stream()
                .noneMatch(value ->
                        (value1 < value && value < value2) || (value2 < value && value < value1));

    }


}

