package idv.kuma._4kyu.snail;


import java.awt.*;
import java.util.*;
import java.util.List;

public class Snail {

    private static Map<String, Point> directionToMovement = new HashMap<>();

    static {
        directionToMovement.put("Right", new Point(0, 1));
        directionToMovement.put("Down", new Point(1, 0));
        directionToMovement.put("Left", new Point(0, -1));
        directionToMovement.put("Up", new Point(-1, 0));
    }

    private static String currentDirection;
    private static Point currentPoint;
    private static List<Point> steppedPoints;


    public static int[] snail(int[][] array) {

        int n = array.length;
        if (n == 0 || array[0].length == 0) return new int[0];


        int numPoints = n * n;

        steppedPoints = new ArrayList();


        // point (0,0) is stepped at beginning
        updateStatus("Right", new Point(0, 0), "Initial ");

        while (!allPointsAreStepped(steppedPoints, numPoints)) {

            List<String> directions = getDirections(currentDirection);

            for (String direction : directions) {

                Point movement = directionToMovement.get(direction);
                Point trialPoint = new Point(currentPoint.x + movement.x, currentPoint.y + movement.y);

                if (goodToGo(trialPoint, n, steppedPoints)) {

                    updateStatus(direction, trialPoint, "Moved ");

                    break;
                }

            }

        }


        // enjoy
        return makeResult(array, steppedPoints);
    }

    static void updateStatus(String direction, Point newPoint, String messageInit) {
        currentDirection = direction;
        currentPoint = newPoint;
        steppedPoints.add(currentPoint);
        System.out.println(messageInit + currentDirection + " -> " + currentPoint);
    }

    private static int[] makeResult(int[][] array, List<Point> steppedPoints) {
        return steppedPoints.stream().mapToInt(point -> array[point.x][point.y]).toArray();
    }

    private static boolean goodToGo(Point trialPoint, int n, List<Point> steppedPoints) {
        // next still in map && next not stepped
        if (trialPoint.x >= n || trialPoint.x < 0) return false;
        if (trialPoint.y >= n || trialPoint.y < 0) return false;
        if (steppedPoints.contains(trialPoint)) return false;

        return true;

    }

    private static boolean allPointsAreStepped(final List<Point> steppedPoints, final int numPoints) {
        return steppedPoints.size() >= numPoints;
    }

    private static List<String> getDirections(String currentDirection) {
        if ("Right".equals(currentDirection)) return Arrays.asList("Right", "Down", "Left", "Up");
        if ("Down".equals(currentDirection)) return Arrays.asList("Down", "Left", "Up", "Right");
        if ("Left".equals(currentDirection)) return Arrays.asList("Left", "Up", "Right", "Down");
        /*("Up".equals(currentDirection))*/
        return Arrays.asList("Up", "Right", "Down", "Left");
    }

}