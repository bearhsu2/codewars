package idv.kuma._4kyu.path_finder_2_shortest_path;

import java.awt.*;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class Finder {

    static int[][] distances;
    static boolean[][] calculated;
    static int n;
    static Queue<Point> reachablePoints;

    public static int pathFinder(String maze) {

        String[] lines = maze.split("\\r?\\n");
        n = lines.length;
        System.out.println("n = " + n);


        if (lines[n - 1].charAt(n - 1) == 'W') {
            return -1;
        }

        distances = initializeDistances(lines);
        calculated = initializeCalculateds(distances);

        reachablePoints = initializeReachablePoints();
        reachablePoints.offer(new Point(0, 0));

        while (!reachablePoints.isEmpty()) {

            Point currentPoint = reachablePoints.poll();
            int currentPointDistance = distances[currentPoint.x][currentPoint.y];

            tryNeighbor(currentPoint.x - 1, currentPoint.y, currentPointDistance);
            tryNeighbor(currentPoint.x + 1, currentPoint.y, currentPointDistance);
            tryNeighbor(currentPoint.x, currentPoint.y - 1, currentPointDistance);
            tryNeighbor(currentPoint.x, currentPoint.y + 1, currentPointDistance);


        }

        // if n,n is less than MAX, then return that number
        // otherwise, return -1;


        return 0;
    }

    static LinkedBlockingQueue<Point> initializeReachablePoints() {
        return new LinkedBlockingQueue<>();
    }

    private static void tryNeighbor(int i, int j, int currentPointDistance) {
        // Check point exists
        if (i < 0 || i >= n || j < 0 || j >= n) return;

        // Check point not calculated (all walls were calculated at beginning)
        if (calculated[i][j]) return;

        // Check point distance can be reduced
        int newDistance = currentPointDistance + 1;
        if (newDistance < distances[i][j]) {
            // reduce point distance
            distances[i][j] = newDistance;

            // put to reachable points if necessary
            Point neighbor = new Point(i, j);
            if (reachablePoints.contains(neighbor)) {
                reachablePoints.offer(neighbor);
            }

        }

    }

    private static int[][] initializeDistances(String[] lines) {

        int[][] result = new int[n][n];

        for (int i = 0; i < lines.length; i++) {
            char[] chars = lines[i].toCharArray();

            for (int j = 0; j < chars.length; j++) {
                if (isRoad(chars[j])) {
                    result[i][j] = Integer.MAX_VALUE;
                } else {
                    result[i][j] = -1;
                }
            }

        }

        result[0][0] = 0;

        return result;
    }

    private static boolean[][] initializeCalculateds(int[][] distances) {

        boolean[][] calculated = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (distances[i][j] > 0) {
                    calculated[i][j] = false;
                } else {
                    calculated[i][j] = true;
                }
            }

        }

        return calculated;
    }

    private static boolean isRoad(int j) {
        return j == '.';
    }


    private static String makeKey(int i, int j) {
        return i + "_" + j;
    }


}