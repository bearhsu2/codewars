package idv.kuma._4kyu.integer_partitions;

import java.text.DecimalFormat;
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

    public static String part(long n) {
        // 1. find partitions
        List<List<Long>> partitions = findPartitions(n);

        // 2. make sorted production list
        List<Long> prod = makeProductions(partitions);

        // 3. format to string return
        return partitionToString(prod);
    }

    public static List<Long> makeProductions(List<List<Long>> partitions) {
        List<Long> result = new ArrayList<>();
        for (List<Long> list : partitions) {
            long prod = list.stream().reduce(1L, (a, b) -> a * b);
            if (!result.contains(prod)) result.add(prod);
        }

        Collections.sort(result);
        return result;
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

        storedPartitionsMap.put(n, result);
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

    private static String partitionToString(List<Long> prod) {

        DecimalFormat df2 = new DecimalFormat(".00");

        double median = prod.get(prod.size() / 2);
        if (prod.size() % 2 == 0) median = (median + prod.get(prod.size() / 2 - 1)) / 2;

        StringBuilder sb = new StringBuilder();
        sb.append("Range: ").append(prod.get(prod.size() - 1) - prod.get(0)).append(" ");
        sb.append("Average: ").append(
                df2.format(prod
                        .stream()
                        .mapToDouble(a -> a)
                        .average().getAsDouble())).append(" ");
        sb.append("Median: ").append(df2.format(median));
        return sb.toString();
    }
}

