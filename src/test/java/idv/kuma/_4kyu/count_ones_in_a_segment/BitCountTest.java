package idv.kuma._4kyu.count_ones_in_a_segment;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;

public class BitCountTest {


    @Test
    public void Input_1_1_Should_Return_1() {
        runAndCheck(1, 1, 1);
    }

    @Test
    public void Input_2_2_Should_Return_0() {
        runAndCheck(2, 2, 1);
    }

    @Test
    public void Input_3_3_Should_Return_2() {
        runAndCheck(3, 3, 2);
    }

    @Test
    public void Input_5_5_Should_Return_3() {
        runAndCheck(5, 5, 2);
    }

    @Test
    public void Input_1_2_Should_Return_2() {
        runAndCheck(1, 2, 2);
    }


    @Test
    public void Input_5_7_Should_Return_7() {
        runAndCheck(5, 7, 7);
    }

    @Test
    public void Input_4_7_Should_Return_8() {
        runAndCheck(4, 7, 8);
    }

    @Test
    public void Input_12_29_Should_Return_51() {
        runAndCheck(12, 29, 51);
    }

    void runAndCheck(int left, int right, int expectedResult) {
        assertEquals(new BigInteger("" + expectedResult), BitCount.countOnes(left, right));
    }

    @Test
    public void test_count_ones_on_one_digit(){
        assertEquals(new BigInteger("" + 8), BitCount.countSumOfOnesOnOneDigitForSingle(15, 1));
        assertEquals(new BigInteger("" + 8), BitCount.countSumOfOnesOnOneDigitForSingle(15, 1));
        assertEquals(new BigInteger("" + 8), BitCount.countSumOfOnesOnOneDigitForSingle(15, 1));
        assertEquals(new BigInteger("" + 8), BitCount.countSumOfOnesOnOneDigitForSingle(15, 1));
    }

    @Test
    public void aaa(){
        System.out.println(Long.toBinaryString(200000000000000L).length());
    }
}