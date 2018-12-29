package idv.kuma._5kyu.matrices_ii_serious_mathematics;

public class Matrix {

    private double[][] elements;

    public Matrix(double[][] elements) {

        if (null == elements || elements.length == 0) throw new IllegalArgumentException();

        int rowLength = -1;
        this.elements = new double[elements.length][];

        for (int i = 0; i < elements.length; i++) {
            double[] row = elements[i];

            int nextRowLength = row.length;
            if (null == row
                    || nextRowLength == 0
                    || (nextRowLength != rowLength && rowLength >= 0)) throw new IllegalArgumentException();
            rowLength = nextRowLength;

            this.elements[i] = elements[i];
        }

        this.elements = elements;
    }

    public Matrix(int rows, int cols, double... elements) {


        this.elements = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.elements[i][j] = elements[i * cols + j];
            }
        }
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