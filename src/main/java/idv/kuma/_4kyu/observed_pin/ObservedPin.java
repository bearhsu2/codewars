package idv.kuma._4kyu.observed_pin;

import java.util.*;

public class ObservedPin {


    private static Map<Character, List<Integer>> observedToPossibles = new HashMap<>();

    private static List<String> possiblePins;
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

        resetResult();

        List<List<Integer>> possiblesList = new ArrayList<>();

        for (char observedChar : entered.toCharArray()) {
            possiblesList.add(observedToPossibles.get(observedChar));
        }

        String prefix = "";
        generatePossiblePins(prefix, possiblesList);


        return possiblePins;
    }

    static void resetResult() {
        possiblePins = new ArrayList<>();
    }

    private static void generatePossiblePins(String prefix, List<List<Integer>> possiblesList) {
        if (possiblesList.size() == 1){
            possiblesList.get(0).forEach( i -> possiblePins.add(prefix + i));

        } else {

            List<Integer> appends = possiblesList.get(0);
            for (int i : appends) {
                generatePossiblePins(prefix + i, possiblesList.subList(1, possiblesList.size()));
            }

        }
    }
}
