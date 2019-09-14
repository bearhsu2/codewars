package idv.kuma._6kyu.stop_gninnips_my_sdrow;

/**
 * Created by bearhsu2 on 3/25/2018.
 */
public class SpinWords {

    public String spinWords(String sentence) {
        String[] words = sentence.split(" ");

        StringBuilder sb = new StringBuilder();
        for (String word : words){
            sb.append(doProcess(word)).append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private String doProcess(String word){
        return word.length() >= 5 ? new StringBuilder(word).reverse().toString() : word;
    }
}