package idv.kuma._3kyu.closest_pair_of_points_in_linearithmic_time;

import java.util.Arrays;
import java.util.List;

public class Kata {

    public static List<Point> closestPair(List<Point> points) {

//        https://www.codewars.com/kata/closest-pair-of-points-in-linearithmic-time/java

        if (points.size() == 2) return Arrays.asList(points.get(0), points.get(1));


        double longestDistance = Double.MAX_VALUE;
        Point a = null;
        Point b = null;

        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {

                Point newA = points.get(i);
                Point newB = points.get(j);

                double newDistance = distance(newA, newB);

                if (newDistance < longestDistance) {
                    if (newDistance < longestDistance) {
                        longestDistance = newDistance;
                        a = newA;
                        b = newB;
                    }
                }
            }

        }
        return Arrays.asList(a, b);
    }

    private static double distance(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }
}