package idv.kuma.lie_strictly;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test1() {
        Assert.assertEquals(7,
                new Solution().solution(new int[]{0, 3, 3, 7, 5, 3, 11, 1}));
    }

}