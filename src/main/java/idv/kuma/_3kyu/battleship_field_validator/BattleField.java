package idv.kuma._3kyu.battleship_field_validator;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class BattleField {


//    https://stackoverflow.com/questions/7501344/how-to-validate-battleship-field
//    http://en.wikipedia.org/wiki/Connected-component_labeling

    public static boolean fieldValidator(int[][] field) {

        if (!checkNumGrids(field)) return false;


        // Connected-component labeling
        LabelingResult labelingResult = labelConnectedComponents(field);

        Map<Integer, List<Point>> labelToPointsMap = labelingResult.getLabelToPointsMap();

        return checkNumShips(labelToPointsMap) && checkShipShapes(labelToPointsMap);
    }

    private static boolean checkNumShips(Map<Integer, List<Point>> labelToPointsMap) {

        List<List<Point>> ships = new ArrayList<>(labelToPointsMap.values());

        if (ships.stream().filter(list -> list.size() == 1).count() != 4L) return false;
        if (ships.stream().filter(list -> list.size() == 2).count() != 3L) return false;
        if (ships.stream().filter(list -> list.size() == 3).count() != 2L) return false;
        if (ships.stream().filter(list -> list.size() == 4).count() != 1L) return false;

        return ships.size() == 1 + 2 + 3 + 4;
    }

    private static boolean checkShipShapes(Map<Integer, List<Point>> labelToPointsMap) {

        List<List<Point>> ships = new ArrayList<>(labelToPointsMap.values());

        return ships.stream().noneMatch(list -> xRange(list) > 1 && yRange(list) > 1);

    }

    private static int xRange(List<Point> points) {
        int min = points.stream().min(Comparator.comparing(Point::getX)).get().x;
        int max = points.stream().max(Comparator.comparing(Point::getX)).get().x;

        return max - min;
    }

    private static int yRange(List<Point> points) {
        int min = points.stream().min(Comparator.comparing(Point::getY)).get().y;
        int max = points.stream().max(Comparator.comparing(Point::getY)).get().y;

        return max - min;
    }

    private static boolean checkNumGrids(int[][] field) {
        return 20 == Arrays.stream(field)
                .mapToInt(innerArray -> IntStream.of(innerArray).sum()) // sum the inner array
                .sum(); // sum the outer array
    }

    private static LabelingResult labelConnectedComponents(int[][] field) {
        int[][] labels = new int[field.length][field[0].length];
        Map<Integer, List<Point>> labelToPointsMap = new HashMap<>();

        // 1. Start from the first pixel in the image. Set current label to 1. Go to (2).
        int nextLabel = 1;
        System.out.println("Start labeling...");
        System.out.println("nextLabel => " + nextLabel);
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {

                // 2. If this pixel is a foreground pixel and it is not already labelled,
                //    give it the current label and add it as the first element in a queue, then go to (3)
                if (isForeground(field[i][j]) && !isLabeled(labels[i][j])) {
                    labels[i][j] = nextLabel;

                    BlockingQueue<Point> queue = new LinkedBlockingQueue<>();
                    queue.offer(new Point(i, j));

                    List<Point> points = new ArrayList<>();
                    points.add(new Point(i, j));
                    labelToPointsMap.put(nextLabel, points);

                    // 3. Pop out an element from the queue, and look at its neighbours
                    //    (based on any type of connectivity). If a neighbour is a foreground pixel
                    //    and is not already labelled, give it the current label and add it to the queue.
                    //    Repeat (3) until there are no more elements in the queue.
                    while (!queue.isEmpty()) {
                        Point point = queue.poll();
                        tryNeighbor(point.x - 1, point.y, field, labels, queue, nextLabel, labelToPointsMap);
                        tryNeighbor(point.x, point.y - 1, field, labels, queue, nextLabel, labelToPointsMap);
                        tryNeighbor(point.x + 1, point.y, field, labels, queue, nextLabel, labelToPointsMap);
                        tryNeighbor(point.x, point.y + 1, field, labels, queue, nextLabel, labelToPointsMap);
                    }

                    // 4. Go to (2) for the next pixel in the image and increment current label by 1.
                    nextLabel++;
                    System.out.println("nextLabel => " + nextLabel);
                }
            }
        }

        return new LabelingResult(labels, labelToPointsMap);
    }

    private static void tryNeighbor(int x, int y, int[][] field, int[][] labels, BlockingQueue<Point> queue, int nextLabel, Map<Integer, List<Point>> labelToPointsMap) {
        // Skip if index out of bound
        if (x < 0 || x > field.length - 1 || y < 0 || y > field[0].length - 1) return;

        if (isForeground(field[x][y]) && !isLabeled(labels[x][y])) {
            labels[x][y] = nextLabel;
            Point newPoint = new Point(x, y);
            queue.offer(newPoint);
            labelToPointsMap.get(nextLabel).add(newPoint);
        }

    }

    private static boolean isForeground(int value) {
        return value == 1;
    }

    private static boolean isLabeled(int value) {
        return value > 0;
    }

    static class LabelingResult {
        private int[][] labels;
        private Map<Integer, List<Point>> labelToPointsMap;

        public LabelingResult(int[][] labels, Map<Integer, List<Point>> labelToPointsMap) {
            this.labels = labels;
            this.labelToPointsMap = labelToPointsMap;
        }

        public int[][] getLabels() {
            return labels;
        }

        public void setLabels(int[][] labels) {
            this.labels = labels;
        }

        public Map<Integer, List<Point>> getLabelToPointsMap() {
            return labelToPointsMap;
        }

        public void setLabelToPointsMap(Map<Integer, List<Point>> labelToPointsMap) {
            this.labelToPointsMap = labelToPointsMap;
        }
    }

}