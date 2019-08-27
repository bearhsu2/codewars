package idv.kuma._3kyu.closest_pair_of_points_in_linearithmic_time;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataTest {


    private List<Point> points;
    private List<Point> actual;
    private List<Point> expected;

    @Test
    public void When_2_Points_Then_Original_Points() {
        makePoints(
                makePoint(2, 2),
                makePoint(6, 3));
        run();
        verify(makePoint(2, 2), makePoint(6, 3));
    }


    @Test
    public void When_3_Points() {
        makePoints(
                makePoint(2, 2),
                makePoint(6, 3),
                makePoint(2, 3));
        run();
        verify(makePoint(2, 2), makePoint(2, 3));
    }


    @Test
    public void When_7_Points() {
        makePoints(
                makePoint(2, 2), //A
                makePoint(2, 8), //B
                makePoint(5, 5), //C
                makePoint(6, 3), //D
                makePoint(6, 7), //E
                makePoint(7, 4), //F
                makePoint(7, 9));  //G
        run();
        verify(makePoint(6, 3), makePoint(7, 4));
    }

    @Test
    public void When_8_Points() {
        makePoints(
                makePoint(2, 2), //A
                makePoint(2, 8), //B
                makePoint(5, 5), //C
                makePoint(6, 3), //D
                makePoint(6, 7), //E
                makePoint(7, 4), //F
                makePoint(7, 9),  //G
                makePoint(77, 99));  //G

        run();
        verify(makePoint(6, 3), makePoint(7, 4));
    }

    @Test
    public void When_Duplicated_Points() {

        List<Point> points = Arrays.asList(
                makePoint(2, 2), //A
                makePoint(2, 8), //B
                makePoint(5, 5), //C
                makePoint(5, 5), //C
                makePoint(6, 3), //D
                makePoint(6, 7), //E
                makePoint(7, 4), //F
                makePoint(7, 9)  //G
        );

        List<Point> result = Kata.closestPair(points);
        List<Point> expected = Arrays.asList(makePoint(5, 5), makePoint(5, 5));
        verify(expected, result);
    }



    @Test
    public void When_Many_Points() {


        int size = 40001;


        Random random = new Random();
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            points.add(makePoint(random.nextDouble() * 30000, random.nextDouble() * 30000));
        }

        List<Point> result = Kata.closestPair(points);

        System.out.println(result);

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

    Point makePoint(double x, double y) {
        return new Point(x, y);
    }
}
