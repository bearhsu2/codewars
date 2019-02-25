package idv.kuma._3kyu.closest_pair_of_points_in_linearithmic_time;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Kata {

    public static List<Point> closestPair(List<Point> points) {

        if (points.size() == 1) return Arrays.asList(points.get(0), points.get(0));

        return Arrays.asList();
    }
}