package idv.kuma._4kyu.count_ones_in_a_segment;


import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.math.BigInteger;

public class BitCountTest {


    @Test
    public void Input_1_1_Should_Return_1() {
        runAndCheck(1, 1, 1);
    }

    @Test
    public void Input_2_2_Should_Return_0() {
        runAndCheck(2, 2, 0);
    }

    @Test
    public void Input_3_3_Should_Return_2() {
        runAndCheck(3, 3, 2);
    }

    @Test
    public void Input_5_5_Should_Return_3() {
        runAndCheck(5, 5, 3);
    }

    @Ignore
    @Test
    public void Input_5_7_Should_Return_7() {
        runAndCheck(5, 7, 7);
    }

    @Ignore
    @Test
    public void Input_12_29_Should_Return_51() {
        runAndCheck(12, 29, 51);
    }

    void runAndCheck(int left, int right, int expectedResult) {
        assertEquals(new BigInteger("" + expectedResult), BitCount.countOnes(left, right));
    }
}