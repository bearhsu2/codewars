package idv.kuma._6kyu.your_order_please;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by bearhsu2 on 3/25/2018.
 */
public class Order {
    public static String order(String words) {

        if (words.equals("")){
            return words;
        }

        List<String> splittedWords = Arrays.asList(words.split(" "));

        splittedWords.sort(Comparator.comparingInt(Order::findNum));

        String joinedString = String.join(" ", splittedWords);

        return joinedString;
    }

    private static int findNum(String input){
        return Integer.parseInt(input.replaceAll("[^1-9]+", ""));
    }
}