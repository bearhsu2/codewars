package idv.kuma._4kyu.magnet_particules_in_boxes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bearhsu2 on 4/1/2018.
 */
class Magnets {

    private static Map<Integer, Map<Integer, Double>> storedV = new HashMap<>();

    public static double doubles(int maxk, int maxn) {
        double result = 0D;

        for (int k = 1; k <= maxk; k++) {
            for (int n = 1; n <= maxn; n++) {
                result += findOrCalculateV(k, n);
            }
        }

        return result;
    }

    private static double findOrCalculateV(int k, int n) {
        // If a value has been calculated, just return it.
        if (isStored(k, n)) return storedV.get(k).get(n);

        double v = calcualteV(k, n);
        storeValue(k, n, v);
        return v;

    }

    private static void storeValue(int k, int n, double v) {
        Map<Integer, Double> subMap = storedV.get(k);

        if (subMap == null) {
            subMap = new HashMap<>();
            storedV.put(k, subMap);
        }

        subMap.put(n, v);
    }

    private static boolean isStored(int k, int n) {
        Map<Integer, Double> subMap = storedV.get(k);
        if (subMap != null) {
            return subMap.containsKey(n);
        }
        return false;
    }

    private static double calcualteV(int k, int n) {
        return 1 / (k * Math.pow(n + 1, 2 * k));
    }
}