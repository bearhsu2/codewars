package idv.kuma._4kyu.count_ones_in_a_segment;


import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.math.BigInteger;

public class BitCountTest {


    @Test
    public void Input_0_0_Should_Return_0() {
        assertEquals(new BigInteger("0"), BitCount.countOnes(0,0));
    }

    @Test
    public void Input_1_1_Should_Return_1() {
        assertEquals(new BigInteger("1"), BitCount.countOnes(1,1));
    }

    @Ignore
    @Test
    public void Input_5_7_Should_Return_7() {
        assertEquals(new BigInteger("7"), BitCount.countOnes(5,7));
    }

    @Ignore
    @Test
    public void Input_12_29_Should_Return_51() {
        assertEquals(new BigInteger("51"), BitCount.countOnes(12,29));
    }
}