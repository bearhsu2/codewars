package idv.kuma._2kyu.insane_colored_triangle;

public class Kata {

    // https://www.codewars.com/kata/5a331ea7ee1aae8f24000175/train/java
    public static char triangle(final String row) {

        if (row.length() == 1) {
            return row.charAt(0);
        }


        char[] charArray = row.toCharArray();
        if (charArray[0] == charArray[1]){
            return charArray[0];
        } else {
            return 'G';
        }



    }


}