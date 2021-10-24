package idv.kuma._4kyu.path_finder_1_can_you_reach_the_exit;

import java.awt.*;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Finder {

    static int[][] reachables;

    static int n;
    static Queue<Point> waitingPoints;

    public static boolean pathFinder(String maze) {

        String[] lines = maze.split("\\r?\\n");
        n = lines.length;

        if (lines[n - 1].charAt(n - 1) == 'W') {
            return false;
        }

        reachables = initializeReachables(lines);

        waitingPoints = initializeWaitingPoints();


        while (!waitingPoints.isEmpty()) {

            Point currentPoint = waitingPoints.poll();
            int currentPointReachable = reachables[currentPoint.x][currentPoint.y];

            tryNeighbor(currentPoint.x - 1, currentPoint.y);
            tryNeighbor(currentPoint.x + 1, currentPoint.y);
            tryNeighbor(currentPoint.x, currentPoint.y - 1);
            tryNeighbor(currentPoint.x, currentPoint.y + 1);

            reachables[currentPoint.x][currentPoint.y] = 1;
        }

        boolean reachable = reachables[n - 1][n - 1] == 1;

        return reachable;

    }


    static Queue<Point> initializeWaitingPoints() {
        Queue<Point> waitingPoints = new LinkedBlockingQueue<>();
        waitingPoints.offer(new Point(0, 0));
        return waitingPoints;
    }

    private static void tryNeighbor(int i, int j) {
        // Check point exists
        if (i < 0 || i >= n || j < 0 || j >= n) return;

        // Check point not calculated (all walls were calculated at beginning)
        if (reachables[i][j] == 1 || reachables[i][j] == -1) return;

        // put to reachable points if necessary
        Point neighbor = new Point(i, j);
        if (!waitingPoints.contains(neighbor)) {
            waitingPoints.offer(neighbor);
        }


    }

    private static int[][] initializeReachables(String[] lines) {

        int[][] reachables = new int[n][n];

        for (int i = 0; i < lines.length; i++) {
            char[] chars = lines[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                reachables[i][j] = isRoad(chars[j]) ? 0 : -1;
            }
        }
        reachables[0][0] = 1;

        return reachables;
    }


    private static boolean isRoad(char c) {
        return c == '.';
    }


}