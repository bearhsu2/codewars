package idv.kuma._5kyu.maximum_subarray_sum;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxTest {


    @Test
    public void When_0_Should_Return_0() throws Exception {
        runAndCheck(0);
    }


    @Test
    public void When_1_2_3_n1_Should_Return_6() throws Exception {
        runAndCheck(6, 1,2,3,-1);
    }


    @Test
    public void testExampleArray() throws Exception {
        runAndCheck(6, -2, 1, -3, 4, -1, 2, 1, -5, 4);
    }

    void runAndCheck(int max, int... ints) {
        assertEquals("Empty arrays should have a max of " + max, max, Max.sequence(ints));
    }

}