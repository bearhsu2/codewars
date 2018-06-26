package idv.kuma._4kyu.count_ones_in_a_segment;

import java.math.BigInteger;

public class BitCount {

    public static BigInteger countOnes(long left, long right) {
        

        if (left == right){
            return countOnesForSingle(left);
        }

        return null;

    }

    static BigInteger countOnesForSingle(long number) {
        return BigInteger.valueOf(Long.toBinaryString(number).replaceAll("0", "").length());
    }
}