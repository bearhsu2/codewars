package idv.kuma._4kyu.integer_partitions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by bearhsu2 on 4/2/2018.
 */
//https://stackoverflow.com/questions/32907406/is-there-an-efficient-algorithm-for-integer-partitioning-with-restricted-number
//https://stackoverflow.com/questions/44359310/integer-partitioning-in-java
//https://introcs.cs.princeton.edu/java/23recursion/Partition.java.html
public class IntPart {

    private static Map<Long, List<List<Long>>> storedPartitionsMap = new HashMap<>();

    {
        System.out.println("STATIC!!!");
        storedPartitionsMap.put(1L, Arrays.asList(Arrays.asList(1L)));
    }

    public static String part(long n) {
        // 1
        List<List<Long>> partitions = findPartitions(n);

        // 2

        // 3

        // format to string return
        return partitionToString();
    }

    public static List<List<Long>> findPartitions(long n) {
        // Return stored partitions if stored already
        List<List<Long>> result = storedPartitionsMap.get(n);
        if (result != null) {
            return result;
        }
        result = new ArrayList<>();

        // Return [[1]] if n is 1
        if (n == 1) {
            result.add(Arrays.asList(n));
            storedPartitionsMap.put(n, result);
            return result;
        }

        // If not found, generate partitions of n
        System.out.printf("Partitions of " + n + " not found. Generate partitions(" + n + ").");
        result = new ArrayList<>();

        result.add(Arrays.asList(n));
        for (long i = n - 1; i >= 1; i--) {
            List<List<Long>> subPartition = findSubPartitions(n - i, i);
            for (List<Long> list : subPartition) {
                result.add(Stream.concat(Arrays.asList(i).stream(), list.stream()).collect(Collectors.toList()));
            }
        }

        return result;
    }

    private static List<List<Long>> findSubPartitions(long n, long max) {
        System.out.println("finding subPartitions for " + n);
        List<List<Long>> candidate = storedPartitionsMap.get(n);
        if (candidate == null) {
            candidate = findPartitions(n);
        }

        List<List<Long>> result = candidate.stream().filter(list -> list.get(0) <= Math.min(n, max)).collect(Collectors.toList());
        return result;
    }

    private static String partitionToString() {
        return "Range: 1 Average: 1.50 Median: 1.50";
    }
}

