package idv.kuma._4kyu.bagels;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class BagelTest {

    @Test
    public void testBagel() {
        Bagel bagel = BagelSolver.getBagel();

        assertEquals(
                bagel.getValue() == 4,
                java.lang.Boolean.TRUE
        );
    }

}