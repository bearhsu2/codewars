package idv.kuma._6kyu.find_odd_int;

import java.util.HashMap;
import java.util.Map;

public class FindOdd {

    public static int findIt(int[] a) {

        Map<Integer, Integer> timesRecord = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            int key = a[i];

            Integer times = timesRecord.get(key);

            if (null == times) {
                timesRecord.put(key, 1);
            } else {
                timesRecord.put(key, times + 1);
            }
        }

        return timesRecord.entrySet().stream().filter(entry -> entry.getValue().intValue() % 2 == 1).findFirst().get().getKey();

    }
}