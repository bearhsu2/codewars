package idv.kuma._4kyu.path_finder_2_shortest_path;

import java.util.HashMap;
import java.util.Map;

public class Finder {

    public static int pathFinder(String maze) {

        String[] lines = maze.split("\\r?\\n");
        int n = lines.length;
        System.out.println("n = " + n);


        if (lines[n - 1].charAt(n - 1) == 'W') {
            return -1;
        }

        Map<String, Integer> distances = makeDistanceMap(lines);
        Map<String, Boolean> calculated = makeCalculatedMap(distances);


        return 0;
    }


    private static Map<String, Integer> makeDistanceMap(String[] lines) {

        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < lines.length; i++) {
            char[] chars = lines[i].toCharArray();

            for (int j = 0; j < chars.length; j++) {
                if (isRoad(chars[j])) {
                    result.put(makeKey(i, j), Integer.MAX_VALUE);
                }
            }

        }


        return result;
    }

    private static Map<String, Boolean> makeCalculatedMap(Map<String, Integer> distances) {
        Map<String, Boolean> calculated = new HashMap<>();

        distances.keySet().forEach(name -> {
            calculated.put(name, Boolean.FALSE);
        });

        return calculated;
    }

    private static boolean isRoad(int j) {
        return j == '.';
    }


    private static String makeKey(int i, int j) {
        return i + "_" + j;
    }


}