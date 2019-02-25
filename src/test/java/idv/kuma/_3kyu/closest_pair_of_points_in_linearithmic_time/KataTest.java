package idv.kuma._3kyu.closest_pair_of_points_in_linearithmic_time;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataTest {


    private List<Point> points;
    private List<Point> actual;
    private List<Point> expected;

    @Test
    public void When_2_Points_Then_Original_Points() {
        makePoints(
                new Point(2, 2),
                new Point(6, 3));
        run();
        verify(new Point(2, 2), new Point(6, 3));
    }


    @Test
    public void When_3_Points() {
        makePoints(
                new Point(2, 2),
                new Point(6, 3),
                new Point(2, 3));
        run();
        verify(new Point(2, 2), new Point(2, 3));
    }


    @Test
    public void test01_Example() {
        makePoints(
                new Point(2, 2), //A
                new Point(2, 8), //B
                new Point(5, 5), //C
                new Point(6, 3), //D
                new Point(6, 7), //E
                new Point(7, 4), //F
                new Point(7, 9));  //G
        run();
        verify(new Point(6, 3), new Point(7, 4));
    }

    @Test
    public void test03_DuplicatedPoint() {

        List<Point> points = Arrays.asList(
                new Point(2, 2), //A
                new Point(2, 8), //B
                new Point(5, 5), //C
                new Point(5, 5), //C
                new Point(6, 3), //D
                new Point(6, 7), //E
                new Point(7, 4), //F
                new Point(7, 9)  //G
        );

        List<Point> result = Kata.closestPair(points);
        List<Point> expected = Arrays.asList(new Point(5, 5), new Point(5, 5));
        verify(expected, result);
    }

    void verify(Point... expectedPoints) {
        expected = Arrays.asList(expectedPoints);
        verify(expected, actual);
    }

    void run() {
        actual = Kata.closestPair(points);
    }

    void makePoints(Point... inputPoints) {

        points = Arrays.asList(inputPoints);
    }

    private void verify(List<Point> expected, List<Point> actual) {
        Comparator<Point> comparer = Comparator.<Point>comparingDouble(p -> p.x);

        Assert.assertNotNull("Returned array cannot be null.", actual);
        Assert.assertEquals("Expected exactly two points.", 2, actual.size());
        Assert.assertFalse("Returned points must not be null.", actual.get(0) == null || actual.get(1) == null);

        expected.sort(comparer);
        actual.sort(comparer);
        boolean eq = expected.get(0).x == actual.get(0).x && expected.get(0).y == actual.get(0).y
                && expected.get(1).x == actual.get(1).x && expected.get(1).y == actual.get(1).y;
        Assert.assertTrue(String.format("Expected: %s, Actual: %s", expected.toString(), actual.toString()), eq);
    }
}
