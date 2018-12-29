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

    public double getElement(int r, int c) {
        return this.elements[r][c];
    }

    public double[][] toArray() {
        return elements;
    }

    public Matrix transpose() {
        return null;
    }

    public Matrix add(Matrix m2) {
        return null;
    }

    public Matrix multiply(int i) {
        return null;
    }

    public Matrix multiply(Matrix m4) {

        return null;
    }

    // TODO: Add transpose, add, mutliply(double), multiply(Matrix)

}