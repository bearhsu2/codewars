package idv.kuma._4kyu.integer_partitions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bearhsu2 on 4/2/2018.
 */
//https://stackoverflow.com/questions/32907406/is-there-an-efficient-algorithm-for-integer-partitioning-with-restricted-number
//https://stackoverflow.com/questions/44359310/integer-partitioning-in-java
//https://introcs.cs.princeton.edu/java/23recursion/Partition.java.html
public class IntPart {

    public static String part(long n) {
        // 1
        List<List<Long>> partitions = generatePartitions(n);

        // 2

        // 3

        // format to string return
        return partitionToString();
    }

    private static List<List<Long>> generatePartitions(long n) {
        List<List<Long>> result = new ArrayList<>();

        result = findSubPartitions(n, n, result);

        return result;
    }

    private static List<List<Long>> findSubPartitions(long n, long max, List<List<Long>> result) {
        if (n == 0L) {
            return null;
        }

        for (int i = (int) Math.min(max, n); i >= 1; i--) {
            findSubPartitions(n - i, i, prefix + " " + i);
        }

        return result;
    }

    private static String partitionToString() {
        return "Range: 1 Average: 1.50 Median: 1.50";
    }
}

