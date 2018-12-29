package idv.kuma._5kyu.matrices_ii_serious_mathematics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix {

    private final double[][] elements;

    public Matrix(double[][] elements) {

        checkNotNull(elements);
        checkPositive(elements.length);

        int knownRowLength = -1;
        double[][] temp = new double[elements.length][];

        for (int i = 0; i < elements.length; i++) {
            double[] row = elements[i];

            checkNotNull(row);
            int nextRowLength = row.length;

            checkPositive(nextRowLength);
            checkConsistency(knownRowLength, nextRowLength);

            knownRowLength = nextRowLength;

            temp[i] = new double[row.length];
            for (int j = 0; j < row.length; j++) {
                temp[i][j] = row[j];
            }
        }

        System.out.println(this);

        this.elements = temp;
    }

    public Matrix(int rows, int cols, double... elements) {

        checkPositive(rows);
        checkPositive(cols);

        checkNotNull(elements);
        checkNumber(rows * cols, elements);

        this.elements = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.elements[i][j] = elements[i * cols + j];
            }
        }
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "elements=" + Arrays.deepToString(elements) +
                '}';
    }

    private void checkNumber(int i, double[] elements) {
        checkEquals(i, elements.length);
    }

    void checkEquals(int myCols, int anotherRows) {
        if (myCols != anotherRows) {
            throw new IllegalArgumentException();
        }
    }

    private void checkConsistency(int knownLength, int nextLength) {
        if (nextLength != knownLength && knownLength >= 0) throw new IllegalArgumentException();
    }

    private void checkPositive(int length) {
        if (length == 0) throw new IllegalArgumentException();
    }

    private void checkNotNull(Object o) {
        if (null == o) throw new IllegalArgumentException();
    }

    public double[][] toArray() {

        int rows = elements.length;
        int cols = elements[0].length;

        double[][] temp = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                temp[i][j] = elements[i][j];
            }
        }

        return elements;
    }

    public Matrix transpose() {

        int rows = elements.length;
        int cols = elements[0].length;

        double[][] result = new double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = elements[i][j];
            }
        }

        return new Matrix(result);
    }

    public Matrix add(Matrix another) {

        System.out.println("this = " + this.toString());
        System.out.println("another = " + another.toString());

        int thisRows = elements.length;
        int thisCols = elements[0].length;

        checkEquals(thisRows, another.elements.length);
        checkEquals(thisCols, another.elements[0].length);


        double[][] result = new double[thisRows][thisCols];

        for (int i = 0; i < thisRows; i++) {
            for (int j = 0; j < thisCols; j++) {
                result[i][j] = elements[i][j] + another.elements[i][j];
            }
        }

        return new Matrix(result);

    }

    public Matrix multiply(double multiplier) {
        int rows = elements.length;
        int cols = elements[0].length;

        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = elements[i][j] * multiplier;
            }
        }

        return new Matrix(result);
    }

    public Matrix multiply(Matrix another) {


        int myRows = elements.length;
        int myCols = elements[0].length;

        double[][] anotherElements = another.elements;
        int anotherRows = anotherElements.length;
        int anotherCols = anotherElements[0].length;

        checkEquals(myCols, anotherRows);

        double[][] result = new double[myRows][anotherCols];

        for (int i = 0; i < myRows; i++) {
            for (int j = 0; j < anotherCols; j++) {
                result[i][j] = getProduct(this.getRow(i), another.getColumn(j));
            }
        }

        return new Matrix(result);

    }

    private double[] getColumn(int j) {
        List<Double> temp = new ArrayList<>();

        for (int i = 0; i < elements.length; i++) {
            temp.add(elements[i][j]);
        }

        return temp.stream().mapToDouble(i -> i).toArray();
    }

    private double[] getRow(int i) {
        return elements[i];
    }


    private double getProduct(double[] a, double[] b) {
        double product = 0D;
        for (int i = 0; i < a.length; i++) {
            product += a[i] * b[i];
        }

        return product;
    }


}