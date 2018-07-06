package idv.kuma._7kyu.coloured_triangles;

public class Kata {

    // https://www.codewars.com/kata/5a331ea7ee1aae8f24000175/train/java
    public static char triangle(final String row) {

        if (row.length() == 1) {
            return row.charAt(0);
        }


        char[] charArray = row.toCharArray();
        return findNextForTwoChars(charArray);


    }

    static char findNextForTwoChars(char[] charArray) {

        if (charArray[0] == charArray[1]) {
            return charArray[0];
        }


        if (charArray[0] == 'R' && charArray[1] == 'G') {
            return 'B';
        }
        if (charArray[0] == 'G' && charArray[1] == 'R') {
            return 'B';
        }
        if (charArray[0] == 'G' && charArray[1] == 'B') {
            return 'R';
        }
        if (charArray[0] == 'B' && charArray[1] == 'G') {
            return 'R';
        }
        if (charArray[0] == 'R' && charArray[1] == 'B') {
            return 'G';
        }

        // (charArray[0] == 'B' && charArray[1] == 'R') {
        return 'G';


    }


}