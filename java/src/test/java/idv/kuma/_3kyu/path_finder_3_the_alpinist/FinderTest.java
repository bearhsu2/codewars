package idv.kuma._3kyu.path_finder_3_the_alpinist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FinderTest {


    @Test
    public void sampleTests() {

        String a = "000\n" +
                "000\n" +
                "000",

                b = "010\n" +
                        "010\n" +
                        "010",

                c = "010\n" +
                        "101\n" +
                        "010",

                d = "0707\n" +
                        "7070\n" +
                        "0707\n" +
                        "7070",

                e = "700000\n" +
                        "077770\n" +
                        "077770\n" +
                        "077770\n" +
                        "077770\n" +
                        "000007",

                f = "777000\n" +
                        "007000\n" +
                        "007000\n" +
                        "007000\n" +
                        "007000\n" +
                        "007777",

                g = "000000\n" +
                        "000000\n" +
                        "000000\n" +
                        "000010\n" +
                        "000109\n" +
                        "001010";

        assertEquals(0, Finder.pathFinder(a));
        assertEquals(2, Finder.pathFinder(b));
        assertEquals(4, Finder.pathFinder(c));
        assertEquals(42, Finder.pathFinder(d));
        assertEquals(14, Finder.pathFinder(e));
        assertEquals(0, Finder.pathFinder(f));
        assertEquals(4, Finder.pathFinder(g));
    }

    @Test
    public void name1() {
        String a =
                "604284093\n" +
                        "067523852\n" +
                        "594228857\n" +
                        "501187929\n" +
                        "485415877\n" +
                        "545025629\n" +
                        "813397488\n" +
                        "743709264\n" +
                        "410558289";

        assertEquals(35, Finder.pathFinder(a));

    }

    @Test
    public void name2() {
        String a =
                "970733179\n" +
                        "939997311\n" +
                        "938710000\n" +
                        "234712272\n" +
                        "229948422\n" +
                        "972498619\n" +
                        "657256054\n" +
                        "172725262\n" +
                        "058122526";


        assertEquals(31, Finder.pathFinder(a));

    }

    @Test
    public void name3() {
        String a = "707777\n" +
                "707007\n" +
                "707077\n" +
                "707070\n" +
                "707077\n" +
                "777007";


        assertEquals(0, Finder.pathFinder(a));

    }
}
