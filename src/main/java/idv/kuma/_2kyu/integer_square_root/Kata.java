package idv.kuma._2kyu.integer_square_root;


import java.util.ArrayList;
import java.util.List;

//https://www.codewars.com/kata/challenge-fun-number-10-integer-square-root/train/java
//http://www.nuprl.org/MathLibrary/integer_sqrt/
public class Kata {

    public static int d = 9;

    public static String integerSquareRoot(String nStr) {

        List<Long> number = separate(nStr);

        return findSquareRoot(number);



    }

    private static String findSquareRoot(List<Long> number) {
        long n = number.get(0);

        double sqrt = Math.floor(Math.sqrt(n));

        int cutted = (int) sqrt;

        return "" + cutted;
    }

    private static List<Long> separate(String nStr) {

        List<Long> sections = new ArrayList<>();

        for (int i = 0; i < nStr.length(); i += d) {
            sections.add(0, Long.valueOf(nStr.substring(i, Math.min(i + d, nStr.length()))));

        }

        return sections;
    }
}
