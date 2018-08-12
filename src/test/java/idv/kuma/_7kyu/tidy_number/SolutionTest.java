package idv.kuma._7kyu.tidy_number;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void Check_1_true() throws Exception {
        assertEquals(true, Solution.tidyNumber(1));
    }


    @Ignore
    @Test
    public void Check_Small_Values() {
        assertEquals(true, Solution.tidyNumber(12));
        assertEquals(false, Solution.tidyNumber(32));
        assertEquals(true, Solution.tidyNumber(39));
    }

    @Ignore
    @Test
    public void Check_Larger_Values() {
        assertEquals(false, Solution.tidyNumber(1024));
        assertEquals(false, Solution.tidyNumber(12576));
        assertEquals(true, Solution.tidyNumber(13579));
        assertEquals(true, Solution.tidyNumber(2335));
    }
}