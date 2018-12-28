package idv.kuma._2kyu.integer_square_root;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OperatorTest {

    @Test
    public void _11_Multiply_By_12_Is_132() throws Exception {
        runMultiplyAndCheck("11", "12", Collections.singletonList(132L));
    }

    @Test
    public void _111111111_Multiply_By_999999999_Is_111111110_888888889() throws Exception {
        runMultiplyAndCheck("111111111", "999999999", Arrays.asList(888888889L, 111111110L));
    }

    @Test
    public void _11_Square_Is_121() throws Exception {
        runSquareAndCheck("11", Collections.singletonList(121L));
    }

    @Test
    public void _111_222_ToString_Is_222111() throws Exception {
        String actual = Kata.Operator.LongsToString(Arrays.asList(111L, 222L));
        Assert.assertEquals("222111", actual);
    }

    @Test
    public void _222111_222111_compare_Is_0() throws Exception {
        int actual = Kata.Operator.compare(Arrays.asList(111L, 222L), Arrays.asList(111L, 222L));
        Assert.assertEquals(0, actual);
    }

    @Test
    public void _222111_111222_compare_Is_1() throws Exception {
        int actual = Kata.Operator.compare(Arrays.asList(111L, 222L), Arrays.asList(222L, 111L));
        Assert.assertEquals(1, actual);
    }

    @Test
    public void _222111_1111111_compare_Is_Neg_1() throws Exception {
        int actual = Kata.Operator.compare(Arrays.asList(111L, 222L), Arrays.asList(111L, 111L, 1L));
        Assert.assertEquals(-1, actual);
    }

    private void runSquareAndCheck(String s, List<Long> expected) {
        List<Long> actual = Kata.Operator.square(Kata.Separator.separate(s));
        Assert.assertEquals(expected, actual);
    }

    void runMultiplyAndCheck(String str1, String str2, List<Long> expected) {
        List<Long> actual = Kata.Operator.multiply(Kata.Separator.separate(str1), Kata.Separator.separate(str2));
        Assert.assertEquals(expected, actual);
    }


}