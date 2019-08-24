package idv.kuma.vi_value;

import org.junit.Ignore;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void test1() {

        assertEquals(5, new Solution().solution(new int[]{4, 2, 2, 4, 2}));
        assertEquals(3, new Solution().solution(new int[]{1, 2, 3, 2}));
        assertEquals(4, new Solution().solution(new int[]{0, 5, 4, 4, 5, 12}));
    }

    @Test
    public void test2() {

        assertEquals(2, new Solution().solution(new int[]{4, 4}));
    }


    @Test
    public void all_different() {

        assertEquals(2, new Solution().solution(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void all_same() {

        assertEquals(5, new Solution().solution(new int[]{1, 1, 1, 1, 1}));
    }


    @Ignore
    @Test
    public void long_array() {

        int[] longArray = IntStream
                .rangeClosed(1, 1_000_000)
                .boxed()
                .mapToInt(value -> value.intValue())
                .toArray();

        assertEquals(2, new Solution().solution(longArray));
    }
}