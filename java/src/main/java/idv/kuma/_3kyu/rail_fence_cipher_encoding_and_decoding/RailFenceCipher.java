package idv.kuma._3kyu.rail_fence_cipher_encoding_and_decoding;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RailFenceCipher {

    static String encode(String s, int n) {
        char[] chars = s.toCharArray();
        String[] shards = new String[n];
        for (int i = 0; i < n; i++) {
            shards[i] = "";
        }

        int index = 0;
        int direction = 1;
        for (int i = 0; i < chars.length; i++) {

            char aChar = chars[i];
            shards[index] += aChar;

            index += direction;

            if (index >= n) {
                index -= 2;
                direction = -1;
            }

            if (index < 0) {
                index += 2;
                direction = 1;
            }


        }

        // Your code here
        String result = Arrays.stream(shards).collect(Collectors.joining());
        return result;
    }

    static String decode(String s, int n) {
        // Your code here
        return "";
    }
}