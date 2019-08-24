package idv.kuma.lie_strictly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8

        List<Pair> pairs = findAdjacentPairs(A);

        return pairs
                .stream()
                .mapToInt(Pair::getIndexDiff)
                .max()
                .orElse(-1);

    }

    private List<Pair> findAdjacentPairs(int[] array) {

        Set<Integer> valueSet = Arrays
                .stream(array)
                .boxed()
                .collect(Collectors.toSet());

        List<Pair> pairs = new ArrayList<>();

        int length = array.length;

        IntStream.range(0, length)
                .filter(i -> i != length - 1)
                .forEach(i -> IntStream.range(i + 1, length)
                        .filter(j -> i != j && isAdjacent(array[i], array[j], valueSet))
                        .forEach(j -> pairs.add(new Pair(i, j)))
                );

        return pairs;
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