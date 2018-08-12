package idv.kuma._7kyu.tidy_number;

public class Solution {
    public static boolean tidyNumber(int number) {


        int remainder = Integer.MAX_VALUE;

        while (number >= 0){

            int newRemainder = number % 10;

            if (newRemainder > remainder){
                return false;
            }

            remainder = newRemainder;
            number /= 10;

        }

        return true;

    }
}