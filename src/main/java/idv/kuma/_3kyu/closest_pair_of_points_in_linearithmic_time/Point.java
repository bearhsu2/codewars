package idv.kuma._3kyu.closest_pair_of_points_in_linearithmic_time;

public class Point {
    public double x, y;

    public Point() {
        x = y = 0.0;
    }

    public Point(double x, double y, Point... points) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%f, %f)", x, y);
    }

    @Override
    public int hashCode() {
        return Double.hashCode(x) ^ Double.hashCode(y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point other = (Point) obj;
            return x == other.x && y == other.y;
        } else {
            return false;
        }
    }
}