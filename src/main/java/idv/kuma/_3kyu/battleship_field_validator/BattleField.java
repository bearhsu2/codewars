package idv.kuma._3kyu.battleship_field_validator;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BattleField {


//    https://stackoverflow.com/questions/7501344/how-to-validate-battleship-field
//    http://en.wikipedia.org/wiki/Connected-component_labeling

    public static boolean fieldValidator(int[][] field) {

        if (!checkNumGrids(field)) return false;


        // Connected-component labeling
        int[][] labelArrays = labelConnecteComponents(field);

        return true;
    }

    private static boolean checkNumGrids(int[][] field) {
        return 20 == Arrays.stream(field)
                .mapToInt(innerArray -> IntStream.of(innerArray).sum()) // sum the inner array
                .sum(); // sum the outer array
    }

    private static int[][] labelConnecteComponents(int[][] field) {
        int[][] labels = new int[field.length][field[0].length];
        int nextLebel = 1;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {

            }
        }


        return labels;
    }

    class LabelingResult {
        int[][] labels;

    }

}