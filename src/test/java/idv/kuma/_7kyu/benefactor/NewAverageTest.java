package idv.kuma._7kyu.benefactor;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NewAverageTest {

    private static void testing(long actual, long expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test1() throws Exception {
        System.out.println("Fixed Tests newAvg");

        double[] a = new double[]{14.0, 30.0, 5.0, 7.0, 9.0, 11.0, 16.0};
        testing(NewAverage.newAvg(a, 90), 628);
    }


    @Test
    public void test2() {


        double[] a = new double[]{14, 30, 5, 7, 9, 11, 15};
        testing(NewAverage.newAvg(a, 92), 645);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException1() {
        System.out.println("--- Exception 1 ---");
        double[] a = new double[]{14, 30, 5, 7, 9, 11, 15};
        NewAverage.newAvg(a, 2);
    }
}