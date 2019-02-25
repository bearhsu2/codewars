package idv.kuma._3kyu.closest_pair_of_points_in_linearithmic_time;

import java.util.Arrays;
import java.util.List;

public class Kata {

    public static List<Point> closestPair(List<Point> points) {


        if (points.size() == 2) return Arrays.asList(points.get(0), points.get(1));



        for (Point point : points) {


        }

        return Arrays.asList(points.get(0), points.get(1));
    }
}