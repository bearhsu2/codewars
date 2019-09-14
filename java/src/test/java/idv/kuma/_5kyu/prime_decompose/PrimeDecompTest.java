package idv.kuma._5kyu.prime_decompose;

import static org.junit.Assert.*;
import org.junit.*;

public class PrimeDecompTest {
    @Test
    public void testPrimeDecompOne() {
        int lst = 7775460;
        assertEquals(
                "(2**2)(3**3)(5)(7)(11**2)(17)",
                PrimeDecomp.factors(lst));
    }

    @Test
    public void testPrimeDecomp7919() {
        int lst = 7919;
        assertEquals(
                "(7919)",
                PrimeDecomp.factors(lst));
    }
}
