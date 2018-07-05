package idv.kuma._2kyu.insane_colored_triangle;

public class Kata {

    // https://www.codewars.com/kata/5a331ea7ee1aae8f24000175/train/java
    public static char triangle(final String row) {

        if (row.length() == 1) {
            return row.charAt(0);
        }


        if (row.equals("RR")){
            return 'R';
        }
        
        return 'B';

    }


}