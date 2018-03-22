package idv.kuma._7kyu.get_the_middle_character;

public class Kata {
    public static String getMiddle(String word) {

        int length = word.length();


        StringBuilder sb = new StringBuilder();
        if (0 == length % 2){
            sb.append(word.charAt(length / 2 - 1));
        }
        sb.append(word.charAt(length / 2));

        return sb.toString();
        //Code goes here!
    }
}
