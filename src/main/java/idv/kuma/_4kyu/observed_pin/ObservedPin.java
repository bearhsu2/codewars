package idv.kuma._4kyu.observed_pin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ObservedPin {


    private static Map<Character, List<Integer>> observedToPossibles;

    static {
        observedToPossibles.put('1', Arrays.asList(1, 2, 4));
        observedToPossibles.put('2', Arrays.asList(1, 2, 3, 5));
        observedToPossibles.put('3', Arrays.asList(2, 3, 6));
        observedToPossibles.put('4', Arrays.asList(1, 4, 5, 7));
        observedToPossibles.put('5', Arrays.asList(2, 4, 5, 6, 8));
        observedToPossibles.put('6', Arrays.asList(3, 5, 6, 9));
        observedToPossibles.put('7', Arrays.asList(4, 7, 8));
        observedToPossibles.put('8', Arrays.asList(5, 7, 8, 9, 0));
        observedToPossibles.put('9', Arrays.asList(6, 8, 9));
        observedToPossibles.put('0', Arrays.asList(0, 8));
    }

    public static List<String> getPINs(String entered) {

        char[] observedChars = entered.toCharArray();

        List<List<Integer>> possiblesList = new ArrayList<>();

        for (char observedChar : observedChars) {
            possiblesList.add(observedToPossibles.get(observedChar));
        }

        generatePossiblePins(possiblesList);


        return null;
    }

    private static void generatePossiblePins(List<List<Integer>> possiblesList) {
        if (possiblesList.size() == 1){

        } else {
            // recursive
        }
    }
}
