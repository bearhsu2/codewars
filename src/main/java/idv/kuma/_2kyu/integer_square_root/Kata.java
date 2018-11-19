package idv.kuma._2kyu.integer_square_root;


import java.util.Map;

//https://www.codewars.com/kata/challenge-fun-number-10-integer-square-root/train/java
//http://www.nuprl.org/MathLibrary/integer_sqrt/
public class Kata {

    public static String integerSquareRoot(String nStr) {

        int n = Integer.valueOf(nStr);

        double sqrt = Math.floor(Math.sqrt(n));

        int cutted = (int) sqrt;

        return "" + cutted;
    }
}
