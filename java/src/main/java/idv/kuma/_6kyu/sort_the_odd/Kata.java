package idv.kuma._6kyu.sort_the_odd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * You have an array of numbers.
 Your task is to sort ascending odd numbers but even numbers must be on their places.

 Zero isn't an odd number and you don't need to move it.
 If you have an empty array, you need to return it.

 *
 */

public class Kata {
    public static int[] sortArray(int[] arrayIn) {
        if (null == arrayIn || arrayIn.length <= 0) {
            return arrayIn;
        }

        int[] arrayOut = new int[arrayIn.length];

        List<Integer> sortedOdds = new ArrayList<>();

        List<Integer> oddIndice = new ArrayList<>();

        for (int i = 0; i < arrayIn.length; i++){
            int element = arrayIn[i];
            if (0 == element || 0 == element % 2){
                arrayOut[i] = arrayIn[i];
            } else {
                oddIndice.add(i);
                sortedOdds.add(element);
            }
        }

        Collections.sort(sortedOdds);

        for (int i = 0; i < sortedOdds.size(); i++){
            arrayOut[oddIndice.get(i)] = sortedOdds.get(i);
        }


        return arrayOut;
    }
}