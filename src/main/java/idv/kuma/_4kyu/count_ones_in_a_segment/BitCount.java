package idv.kuma._4kyu.count_ones_in_a_segment;

import java.math.BigInteger;

public class BitCount {

    public static BigInteger countOnes(long left, long right) {
        return countSumOfOnesForSingle(right).subtract(countSumOfOnesForSingle(left - 1));
    }

    static BigInteger countSumOfOnesOnOneDigitForSingle(long number, int column){

        long divider = (long) Math.pow(2, column);

        long quotient = (number + 1) / divider;

        long rest = (number + 1) - quotient * divider;

        return BigInteger.valueOf(quotient * (long) Math.pow(2, column - 1)+ Math.max(0, rest - (long) Math.pow(2, column - 1)));
    }

    static BigInteger countSumOfOnesForSingle(long number){
        BigInteger result = BigInteger.ZERO;

        for (int column = 1; column <= 50; column++){
            result = result.add(countSumOfOnesOnOneDigitForSingle(number, column));
        }

        return result;
    }
}