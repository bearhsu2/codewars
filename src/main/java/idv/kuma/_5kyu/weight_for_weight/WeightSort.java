package idv.kuma._5kyu.weight_for_weight;


import java.util.*;

/**
 * Created by bearhsu2 on 3/27/2018.
 */
public class WeightSort {

    public static String orderWeight(String string) {
        String[] numStrings = string.split(" ");

        Map<Integer, List<String>> mapWeightToWordList = new HashMap<>();
        // Collections.sort(list);

        // Establish weight map
        for (String word : numStrings){
            int wordWeight = calculateWordWeight(word);

            if (mapWeightToWordList.containsKey(wordWeight)) {
                mapWeightToWordList.get(wordWeight).add(word);
            } else {
                List<String> list = new ArrayList();
                list.add(word);
                mapWeightToWordList.put(wordWeight, list);
            }
        }

        // Prepare answer
        List<Integer> keys = new ArrayList<>();
        keys.addAll(mapWeightToWordList.keySet());
        keys.sort(Integer::compareTo);

        StringBuilder sb = new StringBuilder();
        for (int key : keys){
            List<String> list = mapWeightToWordList.get(key);
            list.sort(String::compareTo);
            sb.append(String.join(" ", list)).append(" ");
        }


        return sb.toString().substring(0, sb.length() - 1);

    }

    private static int calculateWordWeight(String word){
        int weight = 0;
        for (Character c : word.toCharArray()){
            weight += Integer.parseInt("" + c);
        }
        return weight;
    }
}