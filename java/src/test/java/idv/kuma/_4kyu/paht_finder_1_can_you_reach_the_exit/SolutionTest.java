package idv.kuma._4kyu.paht_finder_1_can_you_reach_the_exit;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

// TODO: Replace examples and use TDD development by writing your own tests

public class SolutionTest {

    @Test public void sampleTests() {

        String a = ".W.\n"+
                "WWW\n"+
                "...",

                b = ".W.\n"+
                        ".W.\n"+
                        "W..",

                c = "......\n"+
                        "......\n"+
                        "......\n"+
                        "......\n"+
                        "......\n"+
                        "......",

                d = "......\n"+
                        "......\n"+
                        "......\n"+
                        "......\n"+
                        ".....W\n"+
                        "....W.";

        assertEquals(false,  Finder.pathFinder(a));
        assertEquals(false, Finder.pathFinder(b));
        assertEquals(true,  Finder.pathFinder(c));
        assertEquals(false, Finder.pathFinder(d));
    }
}
