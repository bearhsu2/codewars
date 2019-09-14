package idv.kuma._7kyu.credit_card_mask;


public class Maskify {
    public static String maskify(String str) {

        if (4 >= str.length()){
            return str;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++){
            sb.append(i >= str.length() - 4 ? str.charAt(i) : '#');
        }

        return sb.toString();
    }
}
