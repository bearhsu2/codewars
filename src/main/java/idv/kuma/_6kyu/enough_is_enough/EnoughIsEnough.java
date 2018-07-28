package idv.kuma._6kyu.enough_is_enough;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnoughIsEnough {

    private static Map<Integer, Integer> occurrences = new HashMap<>();

    public static int[] deleteNth(int[] elements, int maxOccurrences) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < elements.length; i++) {

            int element = elements[i];

            Integer occurrence = occurrences.get(element);

            if (null == occurrence){
                occurrence = 1;
                occurrences.put(element, 1);
            } else {
                occurrence += 1;
                occurrences.put(element, occurrence);
            }

            if (occurrence <= maxOccurrences){
                result.add(element);
            }

        }


        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}