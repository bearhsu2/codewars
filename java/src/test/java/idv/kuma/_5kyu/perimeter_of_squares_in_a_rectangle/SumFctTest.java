package idv.kuma._5kyu.perimeter_of_squares_in_a_rectangle;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;


public class SumFctTest {

    @Test
    public void When_0_Then_4() {
        assertEquals(BigInteger.valueOf(4), SumFct.perimeter(BigInteger.valueOf(0)));
    }

    @Test
    public void When_1_Then_8() {
        assertEquals(BigInteger.valueOf(8), SumFct.perimeter(BigInteger.valueOf(1)));
    }

    @Test
    public void When_2_Then_16() {
        assertEquals(BigInteger.valueOf(16), SumFct.perimeter(BigInteger.valueOf(2)));
    }

    @Test
    public void When_3_Then_28() {
        assertEquals(BigInteger.valueOf(28), SumFct.perimeter(BigInteger.valueOf(3)));
    }

    @Test
    public void When_4_Then_48() {
        assertEquals(BigInteger.valueOf(48), SumFct.perimeter(BigInteger.valueOf(4)));
    }

    @Test
    public void When_5_Then_80() {
        assertEquals(BigInteger.valueOf(80), SumFct.perimeter(BigInteger.valueOf(5)));
    }

    @Test
    public void test2() {
        assertEquals(BigInteger.valueOf(216), SumFct.perimeter(BigInteger.valueOf(7)));
    }

    @Test
    public void test3() {
        assertEquals(BigInteger.valueOf(14098308), SumFct.perimeter(BigInteger.valueOf(30)));
    }
}
