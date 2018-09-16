package idv.kuma._4kyu.path_finder_2_shortest_path;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FinderTest {

    @Test public void sampleTests() {

        String a = ".W.\n"+
                ".W.\n"+
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

        assertEquals(a, 4,  Finder.pathFinder(a));
        assertEquals(b, -1, Finder.pathFinder(b));
        assertEquals(c, 10,  Finder.pathFinder(c));
        assertEquals(d, -1, Finder.pathFinder(d));
    }
}

