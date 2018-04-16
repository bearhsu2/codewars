package idv.kuma._4kyu.range_extraction;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SolutionTest {

    @Test
    public void doProcess_1_2_3_5_7() {
        List<List<Integer>> processed = Solution.doProcess(new int[]{1, 2, 3, 5, 7});
        Assert.assertEquals(Stream.of(1, 2, 3).collect(Collectors.toList()), processed.get(0));
        Assert.assertEquals(Stream.of(5).collect(Collectors.toList()), processed.get(1));
        Assert.assertEquals(Stream.of(7).collect(Collectors.toList()), processed.get(2));
    }

    @Test
    public void doProcess_1_2_3_5_7_8_9() {
        List<List<Integer>> processed = Solution.doProcess(new int[]{1, 2, 3, 5, 7, 8, 9});
        Assert.assertEquals(Stream.of(1, 2, 3).collect(Collectors.toList()), processed.get(0));
        Assert.assertEquals(Stream.of(5).collect(Collectors.toList()), processed.get(1));
        Assert.assertEquals(Stream.of(7, 8, 9).collect(Collectors.toList()), processed.get(2));
    }

    @Test
    public void No_Match_Range_1_3_5_7_9() {
        assertEquals("1,3,5,7,9", Solution.rangeExtraction(new int[]{1, 3, 5, 7, 9}));
    }

    @Test
    public void No_Match_Range_n4_n2_0_1_2() {
        assertEquals("-4,-2,0,1,3", Solution.rangeExtraction(new int[]{-4, -2, 0, 1, 3}));
    }

    @Test
    public void No_Match_Range_0_1_2_5_9() {
        assertEquals("0-2,5,9", Solution.rangeExtraction(new int[]{0, 1, 2, 5, 9}));
    }

    @Test
    public void No_Match_Range_1_2_3_4_6() {
        assertEquals("1-4,6", Solution.rangeExtraction(new int[]{1, 2, 3, 4, 6}));
    }


//    @Test
//    public void No_Match_Range_2_4_6_8_10() {
//        assertEquals("2,4,6,8,10", Solution.rangeExtraction(new int[]{2, 4, 6, 8, 10}));
//    }

    @Test
    public void test_BasicTests() {
        assertEquals("-6,-3-1,3-5,7-11,14,15,17-20", Solution.rangeExtraction(new int[]{-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20}));

        assertEquals("-3--1,2,10,15,16,18-20", Solution.rangeExtraction(new int[]{-3, -2, -1, 2, 10, 15, 16, 18, 19, 20}));
    }
}