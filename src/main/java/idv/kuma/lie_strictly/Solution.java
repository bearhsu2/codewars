package idv.kuma.lie_strictly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        List<Pair> pairs = new ArrayList<>();

        int length = array.length;


        for (int i = 0; i < length; i++) {

            for (int j = length - 1; j > i; j--) {

                if (isAdjacent(array[i], array[j], valueSet)) {
                    pairs.add(new Pair(i, j));

                    return j - i;

                }
            }

        }
        return -1;

    }


    private boolean isAdjacent(int value1, int value2, Set<Integer> valueSet) {


        return value1 != value2 && valueSet
                .stream()
                .noneMatch(value ->
                        (value1 < value && value < value2) || (value2 < value && value < value1));

    }


}

class Pair {

    int index1;
    int index2;

    public Pair(int index1, int index2) {
        this.index1 = index1;
        this.index2 = index2;
    }

    public int getIndex1() {
        return index1;
    }


    public int getIndex2() {
        return index2;
    }


    int getIndexDiff() {
        return Math.abs(index1 - index2);
    }
}