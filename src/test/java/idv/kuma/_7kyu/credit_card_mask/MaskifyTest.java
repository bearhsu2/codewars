package idv.kuma._7kyu.credit_card_mask;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaskifyTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSolution() {
        assertEquals(Maskify.maskify("4556364607935616"), "############5616");
        assertEquals(Maskify.maskify(     "64607935616"),      "#######5616");
        assertEquals(Maskify.maskify(               "1"),                "1");
        assertEquals(Maskify.maskify(                ""),                 "");

        // "What was the name of your first pet?"
        assertEquals(Maskify.maskify("Skippy")                                  , "##ippy");
        assertEquals(Maskify.maskify("Nananananananananananananananana Batman!"), "####################################man!");
    }

}