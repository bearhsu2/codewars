package idv.kuma._5kyu.matrices_ii_serious_mathematics;

public class Matrix {

    private double[][] elements;

    public Matrix(double[][] elements) {

        checkNotNull(elements);
        checkPositive(elements.length);

        int knownRowLength = -1;
        this.elements = new double[elements.length][];

        for (int i = 0; i < elements.length; i++) {
            double[] row = elements[i];

            checkNotNull(row);
            int nextRowLength = row.length;

            checkPositive(nextRowLength);
            checkConsistency(knownRowLength, nextRowLength);

            knownRowLength = nextRowLength;

            this.elements[i] = elements[i];
        }

        this.elements = elements;
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

    private void checkNumber(int i, double[] elements) {
        if (i != elements.length) throw new IllegalArgumentException();
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

        int rows = elements.length;
        int cols = elements[0].length;

        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = elements[i][j] + another.elements[i][j];
            }
        }

        return new Matrix(result);

    }

    public Matrix multiply(int multiplier) {
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

    public Matrix multiply(Matrix m4) {

        return null;
    }

    

}