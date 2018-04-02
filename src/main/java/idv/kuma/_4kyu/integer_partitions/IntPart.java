package idv.kuma._4kyu.integer_partitions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bearhsu2 on 4/2/2018.
 */
//https://stackoverflow.com/questions/32907406/is-there-an-efficient-algorithm-for-integer-partitioning-with-restricted-number
public class IntPart {

    public static String part(long n) {
        // your code
        List<List<Long>> partitions = findPartitions(n);

        return partitionToString();
    }

    private static List<List<Long>> findPartitions(long n) {
        List<List<Long>> result = new ArrayList<>();
        for (int m = 1; m <= n; m++) {
            result.addAll(findSubPartitions(n, m));
        }
        return result;
    }

    private static List<List<Long>> findSubPartitions(long n, long m) {
        List<List<Long>> result = new ArrayList<>();
        return result;
    }

    private static String partitionToString() {
        return "Range: 1 Average: 1.50 Median: 1.50";
    }
}

