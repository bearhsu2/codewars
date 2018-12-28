package idv.kuma._2kyu.integer_square_root;


import java.util.ArrayList;
import java.util.List;

//https://www.codewars.com/kata/challenge-fun-number-10-integer-square-root/train/java
//http://www.nuprl.org/MathLibrary/integer_sqrt/
public class Kata {

    public static int d = 9;
    public static long sectionMax = (long) Math.pow(10, 9);

    public static String integerSquareRoot(String nStr) {

        List<Long> number = Separator.separate(nStr);

        return findSquareRoot(number);


    }

    private static String findSquareRoot(List<Long> number) {
        long n = number.get(0);

        double sqrt = Math.floor(Math.sqrt(n));

        int cutted = (int) sqrt;

        return "" + cutted;
    }

    public static class Separator {

        public static List<Long> separate(String nStr) {

            List<Long> sections = new ArrayList<>();

            for (int i = 0; i < nStr.length(); i += d) {
                sections.add(0, Long.valueOf(nStr.substring(i, Math.min(i + d, nStr.length()))));

            }

            return sections;
        }
    }

    public static class Operator {
        public static List<Long> multiply(List<Long> a, List<Long> b) {


            List<List<Long>> temp = new ArrayList<>();

            for (int i = 0; i < a.size() + b.size(); i++) {
                temp.add(new ArrayList<>());
            }

            for (int j = 0; j < b.size(); j++) {
                temp.add(new ArrayList<>());
                for (int i = 0; i < a.size(); i++) {
                    long element = a.get(i) * b.get(j);
                    int digit = i + j;

                    temp.get(digit).add(element);

                }
            }


            List<Long> result = new ArrayList<>();
            long nextCarry = 0;
            for (int i = 0; i < temp.size(); i++) {
                long sum = temp.get(i).stream().mapToLong(Long::longValue).sum() + nextCarry;

                nextCarry = 0;
                if (sum >= sectionMax) {
                    nextCarry = sum / sectionMax;
                    sum %= sectionMax;
                }

                result.add(sum);
            }


            for (int i = result.size() - 1; i >= 0; i--) {
                if (result.get(i) > 0) {
                    break;
                }
                result.remove(i);
            }
            return result;

        }
    }
}
