package idv.kuma._4kyu.path_finder_4_where_are_you;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.awt.*;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class SolutionTest {

    private String path;
    private Point you;
    public SolutionTest(String path, Point you) {
        this.path = path;
        this.you = you;
    }

    @Parameters
    public static Collection<Object[]> prepTests() {
        return Arrays.asList(new Object[]{"", new Point(0, 0)},
                new Object[]{"RLrl", new Point(0, 0)},
                new Object[]{"r5L2l4", new Point(4, 3)},
                new Object[]{"r5L2l4", new Point(0, 0)},
                new Object[]{"10r5r0", new Point(-10, 5)},
                new Object[]{"10r5r0", new Point(0, 0)});
    }

    @Test
    public void test() {
        assertEquals("With path=\"" + path + "\":", you, PathFinder.iAmHere(path));
    }
}