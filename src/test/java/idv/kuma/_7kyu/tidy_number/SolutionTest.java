package idv.kuma._7kyu.tidy_number;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void Check_1_true() throws Exception {
        runAndCheck(true, Solution.tidyNumber(1));
    }


    @Test
    public void Check_10_false() throws Exception {
        runAndCheck(false, Solution.tidyNumber(10));
    }

    @Test
    public void Check_11_true() throws Exception {
        runAndCheck(true, Solution.tidyNumber(11));
    }


    @Test
    public void Check_Small_Values() {
        runAndCheck(true, Solution.tidyNumber(12));
        runAndCheck(false, Solution.tidyNumber(32));
        runAndCheck(true, Solution.tidyNumber(39));
    }

    @Test
    public void Check_Larger_Values() {
        runAndCheck(false, Solution.tidyNumber(1024));
        runAndCheck(false, Solution.tidyNumber(12576));
        runAndCheck(true, Solution.tidyNumber(13579));
        runAndCheck(true, Solution.tidyNumber(2335));
    }

    void runAndCheck(boolean expected, boolean actual) {
        assertEquals(expected, actual);
    }
}