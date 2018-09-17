package idv.kuma._4kyu.path_finder_2_shortest_path;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FinderTest {

    @Test
    public void _1_x_1_No_Wall_Then_Distance_Is_1() throws Exception {
        String a = ".";
        assertEquals(a, 0, Finder.pathFinder(a));
    }


    @Test
    public void _1_x_1_Wall_Then_Distance_Is_Negative_1() throws Exception {
        String a = "W";
        assertEquals(a, -1, Finder.pathFinder(a));
    }


    @Test
    public void _3_x_3_No_Wall_Then_Distance_Is_4() throws Exception {
        String a = "...\n" +
                "...\n" +
                "...";
        assertEquals(a, 4, Finder.pathFinder(a));
    }


    @Test
    public void _3_x_3_A_Wall_In_Middle_Then_Distance_Is_4() throws Exception {
        String a = "...\n" +
                ".W.\n" +
                "...";
        assertEquals(a, 4, Finder.pathFinder(a));
    }

    @Test
    public void _3_x_3_Destination_Unreachable_Then_Distance_Is_Negative_1() throws Exception {
        String a = "..W\n" +
                ".W.\n" +
                "W..";
        assertEquals(a, -1, Finder.pathFinder(a));
    }

    @Test
    public void sampleTests() {

        String a = ".W.\n" +
                ".W.\n" +
                "...",

                b = ".W.\n" +
                        ".W.\n" +
                        "W..",

                c = "......\n" +
                        "......\n" +
                        "......\n" +
                        "......\n" +
                        "......\n" +
                        "......",

                d = "......\n" +
                        "......\n" +
                        "......\n" +
                        "......\n" +
                        ".....W\n" +
                        "....W.";

        assertEquals(a, 4, Finder.pathFinder(a));
        assertEquals(b, -1, Finder.pathFinder(b));
        assertEquals(c, 10, Finder.pathFinder(c));
        assertEquals(d, -1, Finder.pathFinder(d));
    }
}

