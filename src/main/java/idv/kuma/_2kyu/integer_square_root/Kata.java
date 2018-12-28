package idv.kuma._2kyu.integer_square_root;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//https://www.codewars.com/kata/challenge-fun-number-10-integer-square-root/train/java
//http://www.nuprl.org/MathLibrary/integer_sqrt/
//https://www.programcreek.com/2012/02/java-calculate-square-root-without-using-library-method/
public class Kata {

    public static int d = 9;
    public static long sectionMax = (long) Math.pow(10, 9);

    public static String integerSquareRoot(String nStr) {

        List<Long> number = Separator.separate(nStr);

        return Operator.LongsToString(findSquareRoot(number));


    }

    private static List<Long> findSquareRoot(List<Long> number) {


        List<Long> one = Collections.singletonList(1L);
        List<Long> i = Collections.singletonList(1L);
        List<Long> result = Collections.singletonList(1L);


        List<Long> oldI = Collections.singletonList(0L);
        while (Operator.compare(result, number) <= 0) {
            oldI = i;
            i = Operator.add(i, one);
            result = Operator.multiply(result, one);
        }

        return oldI;

//        // Returns floor of square root of x
//        static int floorSqrt(int x)
//        {
//            // Base cases
//            if (x == 0 || x == 1)
//                return x;
//
//            // Staring from 1, try all numbers until
//            // i*i is greater than or equal to x.
//            int i = 1, result = 1;
//
//            while (result <= x) {
//                i++;
//                result = i * i;
//            }
//            return i - 1;
//        }
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

        public static String LongsToString(List<Long> longs){
            StringBuilder sb = new StringBuilder();


            for (int i = longs.size() - 1; i >= 0; i--) {
                sb.append(longs.get(i));
            }

            return sb.toString();
        }

        public static int compare(List<Long> result, List<Long> number) {
            return 0;
        }

        public static List<Long> add(List<Long> i, List<Long> one) {
            return null;
        }

        public static List<Long> square(List<Long> a){
            return multiply(a, a);
        }

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
