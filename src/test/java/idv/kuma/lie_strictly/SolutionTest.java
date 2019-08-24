package idv.kuma.lie_strictly;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test1() {
        Assert.assertEquals(7,
                new Solution().solution(new int[]{0, 3, 3, 7, 5, 3, 11, 1}));
    }


    @Test
    public void test2() {
        Assert.assertEquals(4,
                new Solution().solution(new int[]{1, 4, 7, 3, 3, 5}));
    }

    @Test
    public void no_adjacents() {
        Assert.assertEquals(-1,
                new Solution().solution(new int[]{1, 1, 1}));
    }


    @Test
    public void empty() {
        Assert.assertEquals(-1,
                new Solution().solution(new int[]{}));
    }

    @Test
    public void single() {
        Assert.assertEquals(-1,
                new Solution().solution(new int[]{100}));
    }

}