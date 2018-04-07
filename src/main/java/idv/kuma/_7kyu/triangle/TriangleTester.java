package idv.kuma._7kyu.triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TriangleTester {
    public static boolean isTriangle(int a, int b, int c) {

        List<Integer> points = Arrays.asList(a, b, c);
        points.sort(Integer::compareTo);

        return points.get(0) + points.get(1) > points.get(2);

    }
}