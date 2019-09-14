package idv.kuma._4kyu.snail;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public class SnailTest {

    @Test
    public void When_1_x_1() {
        int[][] array
                = {{1}};

        int[] expected = {1};
        test(array, expected);
    }

    @Test
    public void When_2_x_2() {
        int[][] array
                = {{1, 2},
                {4, 3}};

        int[] expected = {1, 2, 3, 4};
        test(array, expected);
    }

    @Test
    public void When_3_x_3_1() {
        int[][] array
                = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int[] expected = {1, 2, 3, 6, 9, 8, 7, 4, 5};
        test(array, expected);
    }

    @Test
    public void When_3_x_3_2() {
        int[][] array
                = {{1, 3, 2},
                {4, 5, 6},
                {7, 8, 9}};

        int[] expected = {1, 3, 2, 6, 9, 8, 7, 4, 5};
        test(array, expected);
    }

    public void test(int[][] originalArray, int[] expecteds) {
        String text = "input:\n" + int2dToString(originalArray) + "\n\nexpected: \n" + Arrays.toString(expecteds);
        System.out.println(text);

        int[] actuals = Snail.snail(originalArray);
        System.out.println("\nactual: \n" + Arrays.toString(actuals));
        System.out.println("===========================================");
        Assert.assertArrayEquals(expecteds, actuals);
    }


    public String int2dToString(int[][] a) {
        return Arrays.stream(a).map(row -> Arrays.toString(row)).collect(joining("\n"));
    }

}