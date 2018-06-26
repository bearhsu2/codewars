package idv.kuma._4kyu.count_ones_in_a_segment;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class BitCount {


    public static Map<Long, BigInteger> onesForSingle = new HashMap<>();

    public static BigInteger countOnes(long left, long right) {


        BigInteger result = BigInteger.valueOf(0L);
        for (long i = left; i <= right; i++) {
            result = result.add(findOnesForSingle(i));
        }

        return result;

    }

    private static BigInteger findOnesForSingle(long number) {
        BigInteger result = onesForSingle.get(number);

        if (result == null){
            result = countOnesForSingle(number);
            onesForSingle.put(number, result);
        }
        return  result;
        
    }


    static BigInteger countOnesForSingle(long number) {
        return BigInteger.valueOf(Long.toBinaryString(number).replaceAll("0", "").length());
    }
}