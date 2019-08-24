package idv.kuma;


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    private static final int RANGE_END = 1_000_000;
    private static final int RANGE_START = 1;

    public int solution(int[] A) {
        // write your code in Java SE 8

        Set<Integer> set = Arrays.stream(A).boxed().collect(Collectors.toSet());

        return IntStream.rangeClosed(RANGE_START, RANGE_END)
                .filter(i -> !set.contains(i))
                .findFirst()
                .orElse(RANGE_END + 1);
    }

}

