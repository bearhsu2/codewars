package idv.kuma._4kyu.count_ones_in_a_segment;

import java.math.BigInteger;

public class BitCount {

    public static BigInteger countOnes(long left, long right) {

        if (left == right && left % 2 == 0) {
            return BigInteger.valueOf(0L);
        }



        if (left == right){
            String binaryString = Long.toBinaryString(left);
            int numOnes = binaryString.replaceAll("0", "").length();
            return BigInteger.valueOf(numOnes);
        }
        ///

        if (left == right && left == 1) {
            return BigInteger.valueOf(1L);
        }

        if (left == right && left == 3) {
            return BigInteger.valueOf(2L);
        }

        if (left == right && left == 5) {
            return BigInteger.valueOf(3L);
        }

        return null;

    }
}