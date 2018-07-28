package idv.kuma._6kyu.enough_is_enough;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnoughIsEnough {


    public static int[] deleteNth(int[] elements, int maxOccurrences) {

        Map<Integer, Integer> occurrences = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < elements.length; i++) {

            int element = elements[i];

            Integer occurrence = occurrences.get(element);

            occurrence = (null == occurrence) ? 1 : occurrence + 1;

            occurrences.put(element, occurrence);

            if (occurrence <= maxOccurrences) {
                result.add(element);
            }

        }


        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}