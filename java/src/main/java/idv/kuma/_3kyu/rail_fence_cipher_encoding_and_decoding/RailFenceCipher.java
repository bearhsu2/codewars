package idv.kuma._3kyu.rail_fence_cipher_encoding_and_decoding;

import java.util.*;
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
        return String.join("", shards);
    }

    static String decode(String s, int n) {
        // Your code here
        char[] chars = s.toCharArray();
        List<Integer>[] originalIndicesArray = new List[n];
        for (int i = 0; i < n; i++) {
            originalIndicesArray[i] = new ArrayList<>();
        }


        int shardIndex = 0;
        int direction = 1;
        for (int original = 0; original < chars.length; original++) {

            originalIndicesArray[shardIndex].add(original);

            shardIndex += direction;

            if (shardIndex >= n) {
                shardIndex -= 2;
                direction = -1;
            }

            if (shardIndex < 0) {
                shardIndex += 2;
                direction = 1;
            }

        }

        Map<Integer, Integer> encodedToOriginalIndex = new HashMap<>();
        int encodedIndex = 0;
        for (List<Integer> originalIndices : originalIndicesArray) {
            for (Integer originalIndex : originalIndices) {
                encodedToOriginalIndex.put(encodedIndex, originalIndex);
                encodedIndex++;
            }
        }

        char[] decodesChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            int originalIndex = encodedToOriginalIndex.get(i);
            decodesChars[originalIndex] = s.charAt(i);
        }



        return String.valueOf(decodesChars);
    }
}