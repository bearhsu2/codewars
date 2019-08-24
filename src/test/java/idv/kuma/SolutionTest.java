package idv.kuma;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolutionTest {

    @Test
    public void name1() {
        Assert.assertEquals(5,
                new Solution().solution(new int[]{1, 3, 6, 4, 1, 2}));
    }

    @Test
    public void name2() {
        Assert.assertEquals(4,
                new Solution().solution(new int[]{1, 2, 3}));

    }

    @Test
    public void name3() {
        Assert.assertEquals(1,
                new Solution().solution(new int[]{-1, -3}));
    }

    @Test
    public void name4() {

        int[] ints = IntStream
                .rangeClosed(1, 1_000_000)
                .boxed()
                .mapToInt(value -> value.intValue())
                .toArray();




        Assert.assertEquals(1_000_001,
                new Solution().solution(ints));
    }
}