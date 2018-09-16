package idv.kuma._4kyu.path_finder_2_shortest_path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        List<String> waitingForCalculation = makeWaitingList(distances);
        String currentKey = "0_0";

        while (!isFinished(calculated, n)) {

            // add waitingList candidates
            for (findUncalculatedNeighbors(currentKey, calculated)) {

            }

        }


        return 0;
    }

    private static void findUncalculatedNeighbors(String currentKey, Map<String, Boolean> calculated) {
        int i = findI(currentKey);
        int j = findJ(currentKey);

        for (){

        }
        

    }

    private static int findI(String currentKey) {
        return Integer.valueOf(currentKey.split("_")[0]);
    }

    private static int findJ(String currentKey) {
        return Integer.valueOf(currentKey.split("_")[1]);
    }

    private static List<String> makeWaitingList(Map<String, Integer> distances) {
        List<String> result = new ArrayList<>();

        result.add("0_0");

        return result;
    }

    private static boolean isFinished(Map<String, Boolean> calculated, int n) {
        return calculated.get(makeKey(n - 1, n - 1));
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