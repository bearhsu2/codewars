package idv.kuma._4kyu.binary_multiple_of_3;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryRegexpTest {

    @Test
    public void Test_000_true() throws Exception {
        assertEquals(true, BinaryRegexp.multipleOf3().matcher("000").matches());
    }

    @Test
    public void Test_001_false() throws Exception {
        assertEquals(false, BinaryRegexp.multipleOf3().matcher("001").matches());
    }

    @Test
    public void Test_010_false() throws Exception {
        assertEquals(false, BinaryRegexp.multipleOf3().matcher("010").matches());
    }

    @Test
    public void Test_011_true() throws Exception {
        assertEquals(true, BinaryRegexp.multipleOf3().matcher("011").matches());
    }

    @Test
    public void Test_110_true() throws Exception {
        assertEquals(true, BinaryRegexp.multipleOf3().matcher("110").matches());
    }

    @Ignore
    @Test
    public void testSimple() {
        assertEquals(false, BinaryRegexp.multipleOf3().matcher(" 0").matches());
        assertEquals(false, BinaryRegexp.multipleOf3().matcher("abc").matches());
        assertEquals(true, BinaryRegexp.multipleOf3().matcher("000").matches());

        assertEquals(true, BinaryRegexp.multipleOf3().matcher("110").matches());
        assertEquals(false, BinaryRegexp.multipleOf3().matcher("111").matches());
        assertEquals(true, BinaryRegexp.multipleOf3().matcher(Integer.toBinaryString(12345678)).matches());
    }

}