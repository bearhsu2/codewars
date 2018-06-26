package idv.kuma._4kyu.count_ones_in_a_segment;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class BitCount {


    public static Map<Long, BigInteger> onesForSingle = new HashMap<>();

    public static BigInteger countOnes(long left, long right) {
        

        if (left == right){
            return countOnesForSingle(left);
        } else {

            BigInteger result = BigInteger.valueOf(0L);
            for (long i = left; i <= right; i++){
                result = result.add(countOnesForSingle(i));
            }
            return result;
        }

    }

    static BigInteger countOnesForSingle(long number) {
        return BigInteger.valueOf(Long.toBinaryString(number).replaceAll("0", "").length());
    }
}