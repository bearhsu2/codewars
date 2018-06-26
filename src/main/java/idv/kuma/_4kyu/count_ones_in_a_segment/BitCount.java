package idv.kuma._4kyu.count_ones_in_a_segment;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class BitCount {


    public static Map<Long, BigInteger> onesForSingle = new HashMap<>();

    public static BigInteger countOnes(long left, long right) {

        return countSumOfOnesForSingle(right).subtract(countSumOfOnesForSingle(left - 1));

//        BigInteger result = BigInteger.valueOf(0L);
//        for (long i = left; i <= right; i++) {
//            result = result.add(findOnesForSingle(i));
//        }
//
//        return result;

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


    static BigInteger countSumOfOnesOnOneDigitForSingle(long number, int column){

        long divider = (long) Math.pow(2, column);

        long quotient = (number + 1) / divider;

        long temp = quotient * divider;

        long rest = (number + 1) - temp;

        return BigInteger.valueOf(quotient * (long) Math.pow(2, column - 1)+ Math.max(0, rest - (long) Math.pow(2, column - 1)));

    }

    static BigInteger countSumOfOnesForSingle(long number){
        BigInteger result = BigInteger.ZERO;

        for (int column = 1; column <= 48; column++){
            result = result.add(countSumOfOnesOnOneDigitForSingle(number, column));
        }

        return result;
    }
}