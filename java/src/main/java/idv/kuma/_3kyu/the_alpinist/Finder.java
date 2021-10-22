package idv.kuma._3kyu.the_alpinist;


import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Finder {


    private static boolean[][] calculated;
    private static int[][] shortestRounds;
    private static int[][] heights;
    private static Deque<Point> queue;

    // BFS
    static int pathFinder(String maze) {

        System.out.println(maze);

        String[] lines = maze.split("\n");
        int n = lines.length;

        queue = new ArrayDeque<>();

        heights = makeMountains(lines, n);
        shortestRounds = makeRounds(n);
        calculated = makeAllFalseArrays(n);


        queue.add(new Point(0, 0));
        shortestRounds[0][0] = 0; // start from (0, 0), its round should be 0.

        while (!queue.isEmpty()) {

            Point point = queue.poll();


            tryNeighbor(n, point, new Point(point.x, point.y - 1));
            tryNeighbor(n, point, new Point(point.x, point.y + 1));
            tryNeighbor(n, point, new Point(point.x - 1, point.y));
            tryNeighbor(n, point, new Point(point.x + 1, point.y));

            calculated[point.x][point.y] = true;

        }


        // Your code here!!
        return shortestRounds[n - 1][n - 1];
    }

    private static int[][] makeMountains(String[] lines, int n) {


        int[][] mountains = new int[n][n];

        for (int i = 0; i < n; i++) {

            String line = lines[i];
            int[] heights = new int[n];

            for (int j = 0; j < n; j++) {
                heights[j] = line.charAt(j) - 48;
            }

            mountains[i] = heights;


        }
        return mountains;
    }

    private static int[][] makeRounds(int n) {
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {

            int[] rounds = new int[n];
            for (int j = 0; j < n; j++) {
                rounds[j] = Integer.MAX_VALUE;
            }

            result[i] = rounds;
        }

        return result;

    }

    private static boolean[][] makeAllFalseArrays(int n) {
        boolean[][] two_d_booleans = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            two_d_booleans[i] = new boolean[n];
        }
        return two_d_booleans;
    }

    static void tryNeighbor(int n, Point from, Point to) {

        int i = to.x;
        int j = to.y;

        if (i < 0 || i >= n || j < 0 || j >= n) return;
        if (calculated[i][j]) return;

        int newRound = shortestRounds[from.x][from.y] + Math.abs(heights[i][j] - heights[from.x][from.y]);

        if (newRound < shortestRounds[i][j]) {

            shortestRounds[i][j] = newRound;

        }

        if (!queue.contains(to)) {
            queue.add(to);
        }
    }


}