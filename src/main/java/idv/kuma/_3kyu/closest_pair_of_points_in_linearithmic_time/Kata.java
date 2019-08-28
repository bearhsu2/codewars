package idv.kuma._3kyu.closest_pair_of_points_in_linearithmic_time;

import java.util.*;
import java.util.stream.Collectors;

public class Kata {

    public static List<Point> closestPair(List<Point> points) {

//        https://www.codewars.com/kata/closest-pair-of-points-in-linearithmic-time/java
//        https://www.cs.ubc.ca/~liorma/cpsc320/files/closest-points.pdf

        points.sort(Comparator.comparing(point -> point.y));

        SearchResult searchResult = doFindClosestPair(points);
        return searchResult.getPoints();

    }

    private static SearchResult doFindClosestPair(List<Point> points) {

        if (points.size() <= 3) return bruteForce(points);

        Point median = findMedian(points);

        List<Point> leftPoints = points.stream().filter(point -> point.x < median.x).collect(Collectors.toList());
        List<Point> rightPoints = points.stream().filter(point -> point.x >= median.x).collect(Collectors.toList());

        SearchResult leftResult = doFindClosestPair(leftPoints);
        SearchResult rightResult = doFindClosestPair(rightPoints);

        // find result where both points are at the same side
        SearchResult oneSideResult = leftResult.getDistance() < rightResult.getDistance()
                ? leftResult
                : rightResult;
        double oneSideDistance = oneSideResult.getDistance();

        // find right points in x-band
        List<Point> rightPointsInXBand = findRightPointsInXBand(median, rightPoints, oneSideDistance);

        // find cross-side result
        return crossSideResult(leftPoints, rightPointsInXBand, oneSideDistance)
                .orElse(oneSideResult);

    }

    private static List<Point> findRightPointsInXBand(Point median, List<Point> rightPoints, double oneSideDistance) {
        return rightPoints.stream().filter(
                rightPoint -> rightPoint.x <= median.x + oneSideDistance)
                .collect(Collectors.toList());
    }

    private static Optional<SearchResult> crossSideResult(List<Point> leftPoints, List<Point> rightPointsInXBand, double oneSideDistance) {
        double currentMinDistance = oneSideDistance;
        SearchResult crossSideResult = null;

        for (Point leftPoint : leftPoints) {

            // find 1st right point in interest
            int firstRightPointInInterestIndex = getFirstRightPointInInterestIndex(
                    oneSideDistance,
                    rightPointsInXBand,
                    leftPoint);

            // check distance from all right points in interest, if exist
            double maxYValueInInterest = leftPoint.y + oneSideDistance;
            if (firstRightPointInInterestIndex >= 0) {

                for (int i = firstRightPointInInterestIndex; i < rightPointsInXBand.size(); i++) {

                    Point right = rightPointsInXBand.get(i);

                    // skip all points lower than interest zone
                    if (right.y > maxYValueInInterest) {
                        break;
                    }

                    double distance = distance(right, leftPoint);

                    if (distance < currentMinDistance) {
                        currentMinDistance = distance;
                        crossSideResult = new SearchResult(distance, Arrays.asList(leftPoint, right));
                    }

                }

            }

        }
        return Optional.ofNullable(crossSideResult);
    }

    private static Point findMedian(List<Point> points) {
        List<Point> pointsSortedByX = new ArrayList<>(points);
        pointsSortedByX.sort(Comparator.comparing(point -> point.x));
        return pointsSortedByX.get(points.size() / 2);
    }

    private static double pointToY(Point point) {
        return point.y;
    }

    private static int getFirstRightPointInInterestIndex(double oneSideDistance, List<Point> rightPointsInXBand, Point leftPoint) {

        Point target = new Point();
        target.y = leftPoint.y - oneSideDistance;

        int i = Collections.binarySearch(rightPointsInXBand, target, Comparator.comparingDouble(Kata::pointToY));

        return i >= 0
                ? i
                : -i - 1;


    }

    private static SearchResult bruteForce(List<Point> points) {

        double shortestDistance = Double.MAX_VALUE;
        Point a = null;
        Point b = null;

        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {

                Point newA = points.get(i);
                Point newB = points.get(j);

                double newDistance = distance(newA, newB);

                if (newDistance < shortestDistance) {
                    shortestDistance = newDistance;
                    a = newA;
                    b = newB;
                }
            }
        }

        return new SearchResult(shortestDistance, Arrays.asList(a, b));

    }

    private static double distance(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }


}

class SearchResult {
    double distance;
    List<Point> points;

    public SearchResult(double distance, List<Point> points) {
        this.distance = distance;
        this.points = points;
    }

    public double getDistance() {
        return distance;
    }


    public List<Point> getPoints() {
        return points;
    }

}