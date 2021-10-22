package idv.kuma._3kyu.the_alpinist;


import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Finder {


    // BFS
    static int pathFinder(String maze) {

        String[] lines = maze.split("\n");
        int n = lines.length;

        Deque<Point> queue = new ArrayDeque<>();

        int[][] mountains = makeMountains(lines, n);
        int[][] rounds = makeRounds(n);
        boolean[][] calculated = makeAllFalseArrays(n);


        queue.add(new Point(0, 0));

        while (!queue.isEmpty()) {

            Point point = queue.pop();

            //            try up
//            try down
//            try left
//            try right

            if (!calculated[point.x][point.y]) {

            }


        }


        // Your code here!!
        return;
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


}