package idv.kuma._4kyu.pure_hand;


import java.util.ArrayList;
import java.util.List;

public class PureHand {

    static EyesFinder EyesFinder = new EyesFinder();

    public static String solution(String input) {


        List<Integer> tiles = new ArrayList<>();


        return "";
    }


    static List<Integer> toIntegerList(String input) {

        List<Integer> result = new ArrayList<>();

        for (char c : input.toCharArray()) {
            result.add(Integer.parseInt(String.valueOf(c)));
        }


        return result;
    }

    static class EyesFinder {


        public void find(boolean add) {
        }
    }


}