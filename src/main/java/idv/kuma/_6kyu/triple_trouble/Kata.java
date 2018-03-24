package idv.kuma._6kyu.triple_trouble;

/**
 * Created by bearhsu2 on 3/25/2018.
 */
public class Kata {
    public static int TripleDouble(long num1, long num2) {
        int triple = findTriple(num1);

        if (triple == -1) {
            return 0;
        }

        return hasDouble(num2, triple) ? 1 : 0;

    }

    private static int findTriple(long input) {
        char[] temp = String.valueOf(input).toCharArray();

        for (int i = 0; i < temp.length - 2; i++) {
            if (temp[i] == temp[i + 1] && temp[i] == temp[i + 2]) {
                return Character.getNumericValue(temp[i]);
            }
        }

        return -1;
    }

    private static boolean hasDouble(long number, int target) {
        char[] temp = String.valueOf(number).toCharArray();
        char targetChar = Character.forDigit(target, 10);

        for (int i = 0; i < temp.length - 1; i++) {
            if (temp[i] == targetChar && temp[i + 1] == targetChar) {
                return true;
            }
        }
        return false;
    }
}