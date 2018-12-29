package idv.kuma._5kyu.matrices_ii_serious_mathematics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

public class MatrixTest {

    private Matrix m1;
    private Matrix m2;
    private Matrix m3;
    private Matrix m4;

    @Before
    public void setUp() throws Exception {
        m1 = new Matrix(new double[][]{
                new double[]{5, -3, 2.5},
                new double[]{-42.117, 69, 73.614},
                new double[]{52.35, 4, -11},
        });

        m2 = new Matrix(3, 3,
                -4.25, 58.667, 24.3,
                514.5, 88, -144.15,
                499.51, -343.176, 1214.2
        );

        m3 = new Matrix(2, 3,
                1, 2, 3,
                -4, 3, 1
        );

        m4 = new Matrix(3, 2,
                5, 2,
                -4, 1,
                -2, -1
        );
    }

    @Test
    public void Two_Dimension_Constructor_OK() throws Exception {
        Assert.assertArrayEquals(new double[][]{
                new double[]{5, -3, 2.5},
                new double[]{-42.117, 69, 73.614},
                new double[]{52.35, 4, -11},
        }, m1.toArray());
    }

    @Test
    public void Two_Dimension_Constructor_When_Bad_Inputs_Should_Throw_Exception() throws Exception {

        try {
            new Matrix(null);
            throw new Exception("IllegalArgumentException expected.");
        } catch (Exception e) {
            Assert.assertTrue("Wrong error type thrown", e instanceof IllegalArgumentException);
        }

        try {
            new Matrix(new double[0][0]);
            throw new Exception("IllegalArgumentException expected.");
        } catch (Exception e) {
            Assert.assertTrue("Wrong error type thrown", e instanceof IllegalArgumentException);
        }

        try {
            new Matrix(new double[][]{
                    new double[]{5, -3, 2.5, 999},
                    new double[]{-42.117, 69},
            });
            fail("IllegalArgumentException expected.");
        } catch (Exception e) {
            Assert.assertTrue("Wrong error type thrown", e instanceof IllegalArgumentException);
        }

    }

    @Test
    public void Specify_RowAndCol_Constructor_OK() throws Exception {
        Assert.assertArrayEquals(new double[][]{
                new double[]{-4.25, 58.667, 24.3},
                new double[]{514.5, 88, -144.15},
                new double[]{499.51, -343.176, 1214.2}
        }, m2.toArray());
    }

    @Test
    public void Specify_RowAndCol_Constructor_When_Bad_Inputs_Should_Throw_Exception() throws Exception {

        try {
            new Matrix(3, 3,
                    -4.25, 58.667, 24.3,
                    514.5, 88, -144.15,
                    499.51, -343.176
            );
            fail("IllegalArgumentException expected.");
        } catch (Exception e) {
            Assert.assertTrue("Wrong error type thrown", e instanceof IllegalArgumentException);
        }

        try {
            new Matrix(-1, 3,
                    -4.25, 58.667, 24.3,
                    514.5, 88, -144.15,
                    499.51, -343.176
            );
            fail("IllegalArgumentException expected.");
        } catch (Exception e) {
            Assert.assertTrue("Wrong error type thrown", e instanceof IllegalArgumentException);
        }

        try {
            new Matrix(-3, 3);
            fail("IllegalArgumentException expected.");
        } catch (Exception e) {
            Assert.assertTrue("Wrong error type thrown", e instanceof IllegalArgumentException);
        }


    }


    @Ignore
    @Test
    public void Transpose() {

        assertArrayEquals(new double[][]{
                new double[]{5, -42.117, 52.35},
                new double[]{-3, 69, 4},
                new double[]{2.5, 73.614, -11}
        }, m1.transpose().toArray());

        assertArrayEquals(new double[][]{
                new double[]{1, -4},
                new double[]{2, 3},
                new double[]{3, 1}
        }, m3.transpose().toArray());


    }

    @Ignore
    @Test
    public void Add() throws Exception {
        assertArrayEquals(new double[][]{
                new double[]{0.75, 55.667, 26.8},
                new double[]{472.383, 157, -70.536},
                new double[]{551.86, -339.176, 1203.2}
        }, m1.add(m2).toArray());

    }

    @Ignore
    @Test
    public void Multiply() throws Exception {

        assertArrayEquals(new double[][]{
                new double[]{2, 4, 6},
                new double[]{-8, 6, 2}
        }, m3.multiply(2).toArray());

        assertArrayEquals(new double[][]{
                new double[]{-9, 1},
                new double[]{-34, -6}
        }, m3.multiply(m4).toArray());
    }
}