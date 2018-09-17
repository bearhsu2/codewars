package idv.kuma._4kyu.path_finder_2_shortest_path;

import java.awt.*;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Finder {

    static int[][] distances;
    static boolean[][] calculated;
    static int n;
    static Queue<Point> reachablePoints;

    public static int pathFinder(String maze) {
        System.out.println("===============================================");

        String[] lines = maze.split("\\r?\\n");
        n = lines.length;
        System.out.println("maze: \n" + maze);
        System.out.println("n = " + n);


        if (lines[n - 1].charAt(n - 1) == 'W') {
            return -1;
        }

        distances = initializeDistances(lines);
        calculated = initializeCalculateds(distances);
        distances[0][0] = 0;

        reachablePoints = initializeReachablePoints();
        reachablePoints.offer(new Point(0, 0));

        while (!reachablePoints.isEmpty()) {

            Point currentPoint = reachablePoints.poll();
            int currentPointDistance = distances[currentPoint.x][currentPoint.y];

            tryNeighbor(currentPoint.x - 1, currentPoint.y, currentPointDistance);
            tryNeighbor(currentPoint.x + 1, currentPoint.y, currentPointDistance);
            tryNeighbor(currentPoint.x, currentPoint.y - 1, currentPointDistance);
            tryNeighbor(currentPoint.x, currentPoint.y + 1, currentPointDistance);

            calculated[currentPoint.x][currentPoint.y] = true;
        }


        // if n,n is less than MAX, then return that number
        // otherwise, return -1;
        int destinationDistance = distances[n - 1][n - 1];

        return destinationDistance < Integer.MAX_VALUE ? destinationDistance : -1;

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
            if (!reachablePoints.contains(neighbor)) {
                reachablePoints.offer(neighbor);
            }

        }

    }

    private static int[][] initializeDistances(String[] lines) {

        int[][] distances = new int[n][n];

        for (int i = 0; i < lines.length; i++) {
            char[] chars = lines[i].toCharArray();

            for (int j = 0; j < chars.length; j++) {
                distances[i][j] = isRoad(chars[j]) ? Integer.MAX_VALUE : -1;
            }

        }

        return distances;
    }

    private static boolean[][] initializeCalculateds(int[][] distances) {

        boolean[][] calculated = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                calculated[i][j] = distances[i][j] > 0 ? false : true;
            }
        }

        return calculated;
    }

    private static boolean isRoad(int j) {
        return j == '.';
    }


}